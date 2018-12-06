package com.workshop.rabbit.publisher.constants;

public final class RabbitConstants {

	private RabbitConstants() {
		// restrict instantiation
	}

	// Topic exchange name
	public static final String TOPIC_EXCHANGE = "workshop.topic";

	// Routes
	public static final String CREATE_ORDER_ROUTING_KEY = "order.create";
	public static final String CANCEL_ORDER_ROUTING_KEY = "order.cancel";

}
