package br.com.auth.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.auth.dtos.UserDTO;

@Component
public class NotificationPublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbit.exchange.user}")
	private String userTopicExchange;

	@Value("${rabbit.routingKey.user-notification}")
	private String userCreatedKey;

	public void sendUserCreated(UserDTO userDTO) {
		rabbitTemplate.convertAndSend(userTopicExchange, userCreatedKey, userDTO);
	}
}
