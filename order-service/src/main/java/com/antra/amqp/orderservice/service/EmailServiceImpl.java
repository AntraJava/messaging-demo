package com.antra.amqp.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final MessageSendingService service;

    public EmailServiceImpl(MessageSendingService service) {
        this.service = service;
    }

    @Override
    public void sendEmail(String email) {
        service.sendMessage(email);
        System.out.println("A message with email has send to the queue: " + email);
    }
}
