package com.example.rabbitmq.consumer;

import static com.example.rabbitmq.config.RabbitMQConfig.QUEUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.model.Message;


@Service
public class Consumers {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Consumers.class);
	
	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Message message) {
		LOGGER.info(String.format("Received : %s", message));
	}
}
