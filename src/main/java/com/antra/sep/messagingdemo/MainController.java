package com.antra.sep.messagingdemo;

import com.antra.sep.messagingdemo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private EmailService emailService;

    public MainController(EmailService emailService) {
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
