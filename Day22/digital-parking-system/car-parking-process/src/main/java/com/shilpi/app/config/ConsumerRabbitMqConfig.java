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
public class ConsumerRabbitMqConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.start.response.queue.name}")
    private String startQueue;
    @Value("${rabbitmq.end.response.queue.name}")
    private String endQueue;

    @Value("${rabbitmq.start.response.routingkey.name}")
    private String startRoutingKey;
    @Value("${rabbitmq.end.response.routingkey.name}")
    private String endRoutingKey;

    @Bean
    public Queue startResponseQueue() {
        return QueueBuilder.durable(startQueue).build();
    }

    @Bean
    public Queue endResponseQueue() {
        return QueueBuilder.durable(endQueue).build();
    }
    public DirectExchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding blindStartResponseQueue(Queue startResponseQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(startResponseQueue).to(directExchange).with(startRoutingKey);

    }

    @Bean
    public Binding bindEndResponseQueue(Queue endResponseQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(endResponseQueue).to(directExchange).with(endRoutingKey);
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
