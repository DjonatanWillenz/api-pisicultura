package br.com.task.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${mq.queues.notify}")
    private String notify;

    @Bean
    public Queue isnotify() {
        return new Queue(notify, true);
    }
}
