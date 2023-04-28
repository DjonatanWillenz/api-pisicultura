package br.com.task.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.task.dtos.NotificationDTO;

@Component
public class NotificationPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void enviarNotificacao(NotificationDTO dto) throws JsonProcessingException {
        ObjectMapper json = new ObjectMapper();
        var obj = json.writeValueAsString(dto);        
        rabbitTemplate.convertAndSend(queue.getName(), obj);
    }
}
