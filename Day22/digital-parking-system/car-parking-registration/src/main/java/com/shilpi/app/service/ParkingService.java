package com.shilpi.app.service;

import com.shilpi.app.module.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {
    public static final Logger log = LoggerFactory.getLogger(ParkingService.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.start.request.routingkey.name}")
    private String startRequestRoutingKey;
    @Value("${rabbitmq.end.request.routingkey.name}")
    private String endRequestRoutingKey;

    private final AmqpTemplate amqpTemplate;
    public ParkingService( AmqpTemplate amqpTemplate) {
        this.amqpTemplate =amqpTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public String startParkingService(Car car, String slotNumber){
        log.info("Parking slot obtaining: {}" + slotNumber);
        amqpTemplate.convertAndSend(exchange, startRequestRoutingKey, car);
        return "Parking process initiated...";
    }

    public String endParkingService( String slotNumber){
        log.info("Parking slot delivering: {}" + slotNumber);
        amqpTemplate.convertAndSend(exchangeName, endRequestRoutingKey, slotNumber);
        return "Parking process ending...";
    }

    @RabbitListener(queues = "${rabbitmq.start.response.queue.name}")
    public void handleStartResponse(String response) {
        log.info("Received start response: {}" + response);
    }

    @RabbitListener(queues = "${rabbitmq.end.response.queue.name}")
    public void handleEndResponse(String response) {
        log.info("Received end response: {}" + response);
    }
}
