package com.antra.amqp.orderservice.service;

import com.antra.amqp.orderservice.OrderServiceApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSendingService {

    private final RabbitTemplate rabbitTemplate;

    public MessageSendingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(OrderServiceApplication.topicExchangeName, "foo.bar.baz", message);
    }
}
