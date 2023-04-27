package br.com.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.notification.dtos.NotificationDTO;
import br.com.notification.models.Notification;
import br.com.notification.repository.NotificationRepository;

@Service
public class NotificacaoService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Transactional
    public Notification create(NotificationDTO dto) {
        Notification notificacao = new Notification();
        notificacao.setTitle(dto.getTitle());
        notificacao.setDescription(dto.getDescription());
        return notificationRepository.save(notificacao);
    }

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

}
