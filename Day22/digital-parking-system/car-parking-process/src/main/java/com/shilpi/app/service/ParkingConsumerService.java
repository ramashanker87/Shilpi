package com.shilpi.app.service;

import com.ajay.app.module.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ParkingConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ParkingConsumerService.class);
    private final AmqpTemplate consumerAmqpTemplate;
    public ParkingConsumerService(AmqpTemplate consumerAmqpTemplate) {
        this.consumerAmqpTemplate = consumerAmqpTemplate;
    }

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.start.response.routingkey.name}")
    private String startResponseRoutingKeyName;
    @Value("${rabbitmq.end.response.routingkey.name}")
    private String endResponseRoutingKeyName;

    @RabbitListener(queues = "${rabbitmq.start.request.queue.name}")
    public void processStartRequest(Car car) {
        logger.info("Processing parking start request for car: " + car);

        String responseMessage = "Response - Parking started for car : " + car;


        consumerAmqpTemplate.convertAndSend(exchangeName, startResponseRoutingKeyName, responseMessage);
    }


    @RabbitListener(queues = "${rabbitmq.end.request.queue.name}")
    public void processEndRequest(String parkingNumber) {
        logger.info("Processing parking end request for number: " + parkingNumber);

        String responseMessage = "Response -Parking ended for number: " + parkingNumber;

        consumerAmqpTemplate.convertAndSend(exchangeName, endResponseRoutingKeyName, responseMessage);
    }
}
