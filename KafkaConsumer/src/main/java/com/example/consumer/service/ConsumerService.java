package com.example.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.consumer.model.Product;


@Service
public class ConsumerService {
	Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	
	@KafkaListener(topics = "test-topic", groupId = "group_id")
	public void consume(String message) {
		logger.info(String.format("Receiving message -> %s", message));
	}
	
	@KafkaListener(topics = "test-topic", groupId = "group_id")
	public void consume(Product product) {
		logger.info(String.format("Receiving message -> %s", product.toString()));
	}
}
