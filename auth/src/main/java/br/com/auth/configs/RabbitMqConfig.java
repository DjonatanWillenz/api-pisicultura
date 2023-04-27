package br.com.auth.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Value("${rabbit.exchange.user}")
	private String userTopicExchange;

	@Value("${rabbit.routingKey.user-notification}")
	private String userRoutingKeyCreated;

	@Value("${rabbit.queue.user-notification-created}")
	private String userQueueCreated;

	@Bean
	TopicExchange userTopicExchange() {
		return new TopicExchange(userTopicExchange);
	}

	@Bean
	Queue userQueueCreated() {
		return new Queue(userQueueCreated, true);
	}

	@Bean
	Binding userNotificationBinding(TopicExchange topicExchange) {
		return BindingBuilder.bind(userQueueCreated()).to(topicExchange).with(userRoutingKeyCreated);
	}
	
	@Bean
	MessageConverter json() {
		return new Jackson2JsonMessageConverter();
	}
}
