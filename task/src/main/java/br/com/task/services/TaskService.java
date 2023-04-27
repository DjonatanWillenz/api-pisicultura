package br.com.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.task.dtos.NotificationDTO;
import br.com.task.infra.NotificationPublisher;
import br.com.task.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private NotificationPublisher notificationPublisher;

    public void notificar() throws JsonProcessingException {

        
        taskRepository.findAll()
                .stream().forEach(
                        i -> {
                            System.err.println(i.getTitle());
                        });

        notificationPublisher.enviarNotificacao(
                NotificationDTO.builder()
                        .texto("Mensagem de teste")
                        .titulo("Title")
                        .build());
    }
}
