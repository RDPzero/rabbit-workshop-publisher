package com.workshop.rabbit.publisher.schedulers;

import static com.workshop.rabbit.publisher.constants.RabbitConstants.CANCEL_ORDER_ROUTING_KEY;
import static com.workshop.rabbit.publisher.constants.RabbitConstants.CREATE_ORDER_ROUTING_KEY;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.workshop.rabbit.publisher.dto.Order;
import com.workshop.rabbit.publisher.publishers.OrderPublisher;

@EnableScheduling
@Component
public class OrderScheduler {

	@Autowired
	private OrderPublisher orderPublisher;

	private final Logger logger = LoggerFactory.getLogger(OrderScheduler.class);
	private int orderId = 0;

	@Scheduled(fixedDelay = 10000, initialDelay = 500)
	public void createOrder() {
		logger.info("createOrder starting with {}", orderId);
		Order order = new Order();
		order.setId(orderId);
		order.setDescription("description");
		orderPublisher.publish(CREATE_ORDER_ROUTING_KEY, order);
		orderId++;
	}

	@Scheduled(fixedDelay = 20000, initialDelay = 10000)
	public void cancelOrder() {
		logger.info("cancelOrder starting with {}", orderId);
		Order order = new Order();
		order.setId(orderId);
		order.setDescription("description");
		orderPublisher.publish(CANCEL_ORDER_ROUTING_KEY, order);
	}
}