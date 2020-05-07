package com.antra.sep.messagingdemo;

import com.antra.sep.messagingdemo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class MainControllerMultithreading {

    private static final Logger log = LoggerFactory.getLogger(MainControllerMultithreading.class);

    private EmailService emailService;

    private ExecutorService es = Executors.newFixedThreadPool(50);

    public MainControllerMultithreading(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/placeOrderMT")
    public String order() {
        log.warn("Order received:" + new Date());
        //omit other process
        //...
        //at last
        es.submit(()->emailService.sendEmail("Dummy email content " + new Date()));
        return "order done";
    }
}
