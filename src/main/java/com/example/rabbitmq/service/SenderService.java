package com.example.rabbitmq.service;

import static com.example.rabbitmq.config.RabbitMQConfig.BINDING;
import static com.example.rabbitmq.config.RabbitMQConfig.EXCHANGE;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.model.Message;

@Service
public class SenderService {

	private RabbitTemplate rabbitTemplate;

	@Autowired
	public SenderService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void send(Message message) {
		message.setLocalDateTime(LocalDateTime.now());
		rabbitTemplate.convertAndSend(EXCHANGE, BINDING, message);
	}
}
