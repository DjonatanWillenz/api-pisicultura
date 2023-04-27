package br.com.api.services;

import java.util.Optional;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.PasswordDao;
import br.com.api.dtos.PasswordUpdateDto;
import br.com.api.dtos.SendEmailDto;
import br.com.api.models.Password;
import br.com.api.models.UserSystem;
import br.com.api.utils.UtilsDate;
import br.com.api.utils.UtilsMd5;

@Service
public class PasswordService {

    @Autowired
    private PasswordDao passwordDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SendMailService sendMailService;

    @Transactional
    public Password save(String password, UserSystem user) throws Exception {
        Password pass = new Password();
        pass.setUser(user);
        pass.setDate(UtilsDate.getInstance().getDateCurrent());
        pass.setPassword(UtilsMd5.getInstance().convert(password));
        return passwordDao.saveAndFlush(pass);
    }

    @Transactional
    public Password updatePassword(PasswordUpdateDto dto) throws Exception {
        Password pass = findByUsername(dto.getUsername());
        if (!pass.getPassword().equals(UtilsMd5.getInstance().convert(dto.getOld())))
            throw new Exception("A senha é inválida!");
        if (dto.getNewPass().length() < 8)
            throw new Exception("A nova senha deve conter mais de 8 caracteres!");
        pass.setPassword(UtilsMd5.getInstance().convert(dto.getNewPass()));        
        if (passwordDao.saveAndFlush(pass) != null) {
            String emailTo = emailService.findByIdUser(pass.getUser().getId()).getEmail();
            sendMailService.save(
                    SendEmailDto.builder()
                            .tomail(emailTo)
                            .title("Sua senha foi alterada com sucesso!")
                            .body("Html")
                            .build());
        }
        return pass;
    }

    public Password findByUsername(String username) throws Exception {
        return Optional.of(passwordDao.findAll((root, query, cb) -> {
            root.fetch("user");
            Join<?, ?> user = root.join("user");
            return cb.and(
                    cb.equal(user.get("username"), username));
        })).orElseThrow(() -> new Exception("Usuário não encontrado!"))
                .get(0);
    }
}
