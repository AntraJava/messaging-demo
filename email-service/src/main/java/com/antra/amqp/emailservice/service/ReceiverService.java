package com.antra.amqp.emailservice.service;

import org.springframework.stereotype.Component;

@Component
public class ReceiverService {
    public void receiveMessage(String message) {
        //assume this is a slow process
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Received <" + message + ">");
    }
}

