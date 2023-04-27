package br.com.notification.infra;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificationSubscriber {

    @RabbitListener(queues = "${mq.queues.notify}")
    public void notification(@Payload String payload) {
        
    }
}
