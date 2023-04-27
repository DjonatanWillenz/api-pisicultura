package br.com.api.services;

import br.com.api.configs.UserApp;
import br.com.api.daos.EmailDao;
import br.com.api.daos.UserSystemDao;
import br.com.api.dtos.NotificationDto;
import br.com.api.dtos.PasswordUpdateDto;
import br.com.api.dtos.RestDto;
import br.com.api.dtos.SendEmailDto;
import br.com.api.dtos.UserDto;
import br.com.api.dtos.SettingsDto;
import br.com.api.dtos.UserCreateDto;
import br.com.api.enums.NotificationStateEnum;
import br.com.api.models.UserSystem;
import br.com.api.utils.UtilsDate;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserSystemDao userDao;

  @Autowired
  private SettingsService settingsService;

  @Autowired
  private NotificationService notificationService;

  @Autowired
  private LogService logService;

  @Autowired
  private RequestPasswordService requestPasswordService;

  @Autowired
  private PasswordService passwordService;

  @Autowired
  private EmailService emailService;

  @Autowired
  private EmailDao emailDao;

  @Autowired
  private SendMailService sendMailService;

  @Transactional
  public RestDto save(UserCreateDto user) throws Exception {
    try {
      if (userDao.findByUsername(user.getUsername()).isPresent())
        throw new Exception("Nome de usuário já cadastrado!");

      if (emailDao.findByEmail(user.getEmail()).isPresent())
        throw new Exception("E-mail já cadastrador por outro usuário!");

      UserSystem userSystem = new UserSystem();
      userSystem.setName(user.getName());
      userSystem.setUsername(user.getUsername());
      userSystem.setDateCreate(UtilsDate.getInstance().getDateCurrent());

      userSystem = userDao.saveAndFlush(userSystem);

      user.setEmail(emailService.save(user.getEmail(), userSystem).getEmail());
      user.setPassword(passwordService.save(user.getPassword(), userSystem).getPassword());

      settingsService.save(
          SettingsDto.builder()
              .iduser(userSystem.getId())
              .notify(true)
              .build());

      notificationService.save(
          NotificationDto.builder()
              .iduser(userSystem.getId())
              .title(String.format("Olá, sejá bem vindo!", userSystem.getName()))
              .description("Já realizamos todas as configurações iniciais do sistema, acesse o " +
                  "painel de configurações de usuário e personalize suas opções de notificações conforme sua preferencia!")
              .state(NotificationStateEnum.PENDING)
              .build());

      String keyConfirmation = requestPasswordService.createNewRegister(userSystem);

      sendMailService.save(SendEmailDto.builder()
          .tomail(user.getEmail())
          .title("Confirmação de cadastro")
          .body("Clique aqui para confirmar o cadastro: <link>" + UserApp.getInstance().getUrl() +
              "app/user/confirm" + user.getUsername() + "/" + keyConfirmation + " </link>")
          .build());

      return RestDto.builder()
          .message(
              "Solicitação de cadastro do usuário criada com sucesso, para confirmar seu cadastro acesse seu e-mail!")
          .build();
    } catch (Exception e) {
      logService.createLog(
          e.getMessage(),
          "Ocorreu um erro inesperado",
          e.getLocalizedMessage(),
          "Cadastro de usuários");
      throw e;
    }
  }

  @Transactional
  public UserSystem path(Long iduser, UserDto user) {
    return null;
  }

  @Transactional
  public void delete(Long iduser) {

  }

  public UserSystem findByUsername(String username) throws UsernameNotFoundException {
    return Optional.of(userDao.findByUsername(username))
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!")).get();
  }

  public UserSystem findById(Long id) {
    return userDao.findById(id).get();
  }

  @Transactional
  public void resetPassword(String username) throws Exception {
    UserSystem user = findByUsername(username);
    if (user.isActive())
      throw new Exception("Usuário não esta ativo!");
    if (requestPasswordService.createRequestUpdatePassword(user))
      throw new Exception("Criado solicitação com sucesso!");
  }

  @Transactional
  public UserDto updatePassword(PasswordUpdateDto dto) throws Exception {
    UserSystem usr = passwordService.updatePassword(dto).getUser();
    return UserDto.builder()
        .name(usr.getName())
        .email(usr.getEmail().getEmail())
        .password(usr.getPassword().getPassword())
        .build();
  }

  @Transactional
  public UserDto confirmRegister(String username, String key) throws Exception {
    UserSystem usr = Optional.ofNullable(userDao.findByUsername(username)).get()
        .orElseThrow(() -> new Exception("Usuário não encontrado!"));
    if (requestPasswordService.validateKeyUpdatePassword(usr.getId(), key)) {
      usr.setActive(true);
      userDao.saveAndFlush(usr);
    }
    return UserDto.builder()
        .name(usr.getName())
        .email(usr.getEmail().getEmail())
        .password(usr.getPassword().getPassword())
        .build();
  }
}
