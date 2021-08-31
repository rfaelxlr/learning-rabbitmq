package com.example.rabbitmq.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.model.Message;
import com.example.rabbitmq.service.SenderService;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerRest {

	private SenderService rabbitMqSender;

	@Autowired
	public ProducerRest(SenderService rabbitMqSender) {
		this.rabbitMqSender = rabbitMqSender;
	}

	@PostMapping(value = "message")
	public Message publishUserDetails(@RequestBody Message message) {
		rabbitMqSender.send(message);
		return message;
	}
}
