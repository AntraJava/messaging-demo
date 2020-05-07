package com.antra.amqp.orderservice.controller;

import com.antra.amqp.orderservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OderController {
    private static final Logger log = LoggerFactory.getLogger(OderController.class);

    private EmailService emailService;

    public OderController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/placeOrder")
    public String order() {
        log.warn("Order received:" + new Date());
        //omit other process
        //...
        //at last
        emailService.sendEmail("Dummy email content " + new Date());
        return "order done";
    }
}
