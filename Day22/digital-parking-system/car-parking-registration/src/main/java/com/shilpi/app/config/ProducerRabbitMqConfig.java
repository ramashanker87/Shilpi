package com.shilpi.app.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerRabbitMqConfig {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.start.request.queue.name}")
    private String startRequestQueue;
    @Value("${rabbitmq.end.request.queue.name}")
    private String endRequestQueue;
    @Value("${rabbitmq.start.response.queue.name}")
    private String startResponseQueue;
    @Value("${rabbitmq.end.response.queue.name}")
    private String endResponseQueue;

    // Routing Keys
    @Value("${rabbitmq.start.request.routingkey.name}")
    private String startRequestRoutingKey;
    @Value("${rabbitmq.end.request.routingkey.name}")
    private String endRequestRoutingKey;

    // Routing Keys
    @Value("${rabbitmq.start.response.routingkey.name}")
    private String startResponseRoutingKey;
    @Value("${rabbitmq.end.response.routingkey.name}")
    private String endResponseRoutingKey;

    @Bean
    public Queue createStartRequestQueue() {
        return QueueBuilder.durable(startRequestQueue).build();
    }

    @Bean
    public Queue createEndRequestQueue() {
        return QueueBuilder.durable(endRequestQueue).build();
    }

    @Bean
    public Queue createStartResponseQueue() {
        return QueueBuilder.durable(startResponseQueue).build();
    }

    @Bean
    public Queue createEndResponseQueue() {
        return QueueBuilder.durable(endResponseQueue).build();
    }

    @Bean
    public DirectExchange declareDirectExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding blindStartRequestQueue(Queue createStartRequestQueue, DirectExchange declareDirectExchang) {
        return BindingBuilder.bind(createStartRequestQueue).to(declareDirectExchang).with(startRequestRoutingKey);

    }

    @Bean
    public Binding bindEndRequestQueue(Queue createEndRequestQueue, DirectExchange declareDirectExchang) {
        return BindingBuilder.bind(createEndRequestQueue).to(declareDirectExchang).with(endRequestRoutingKey);
    }

    @Bean
    public Binding blindStartResponseQueue(Queue createStartResponseQueue, DirectExchange declareDirectExchang) {
        return BindingBuilder.bind(createStartResponseQueue).to(declareDirectExchang).with(startResponseRoutingKey);

    }

    @Bean
    public Binding bindEndResponseQueue(Queue createEndResponseQueue, DirectExchange declareDirectExchang) {
        return BindingBuilder.bind(createEndResponseQueue).to(declareDirectExchang).with(endResponseRoutingKey);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
