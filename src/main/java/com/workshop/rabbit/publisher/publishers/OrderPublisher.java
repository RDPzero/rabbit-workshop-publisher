package com.workshop.rabbit.publisher.publishers;

import static com.workshop.rabbit.publisher.constants.RabbitConstants.TOPIC_EXCHANGE;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workshop.rabbit.publisher.dto.Order;

@Component
public class OrderPublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void publish(String routingKey, Order order) {
		rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, routingKey, order);
	}
}
