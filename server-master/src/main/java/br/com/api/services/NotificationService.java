package br.com.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.NotificationDao;
import br.com.api.daos.UserSystemDao;
import br.com.api.dtos.NotificationDto;
import br.com.api.enums.NotificationStateEnum;
import br.com.api.models.Notification;
import br.com.api.models.UserSystem;

@Service
public class NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private UserSystemDao userDao;

    @Transactional
    public void save(NotificationDto notificationDto) throws Exception {
        UserSystem user = userDao.findById(notificationDto.getIduser())
                .orElseThrow(() -> new Exception("Erro ao cadastrar notification!!"));
        Notification notificacao = new Notification();
        notificacao.setUser(user);
        notificacao.setTitle(notificationDto.getTitle());
        notificacao.setDescription(notificationDto.getDescription());
        notificacao.setState(notificationDto.getState());
        notificationDao.save(notificacao);
    }

    public List<NotificationDto> findByIdUser(Long id) {
        List<NotificationDto> list = new ArrayList<>();
        notificationDao.findAll((root, query, cb) -> {
            root.fetch("user");
            Join<?, ?> user = root.join("user");
            return cb.equal(user.get("id"), id);
        }).stream().forEach(e -> list.add(NotificationDto.builder()
                .id(e.getId())
                .title(e.getTitle())
                .iduser(e.getUser().getId())
                .description(e.getDescription())
                .state(e.getState())
                .build()));
        return list;
    }

    public Notification getById(Long id) {
        Optional<Notification> notification = notificationDao.findById(id);
        return notification.isPresent() ? notification.get() : null;
    }

    @Transactional
    public void deleteById(Long id) {
        notificationDao.deleteById(id);
    }

    public List<Notification> findPending() throws Exception {
        return Optional.ofNullable(notificationDao.findAll((root, query, cb) -> {
            root.fetch("user");
            return cb.and(
                    cb.or(cb.equal(root.get("state"), NotificationStateEnum.PENDING),
                            cb.equal(root.get("state"), NotificationStateEnum.ERROR)));
        })).orElseThrow(() -> new Exception("Não encontrado nenhuma informação"));
    }
}
