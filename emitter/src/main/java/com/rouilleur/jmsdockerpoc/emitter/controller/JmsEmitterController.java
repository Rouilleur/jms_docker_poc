package com.rouilleur.jmsdockerpoc.emitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsEmitterController {


    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsEmitterController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    //get qui envoie -> c'est mal !!!
    @GetMapping("/sendMessage")
    public String sendAMessage(){

        System.out.println("Sending a message");

        jmsTemplate.convertAndSend("input.queue","simple string message");

        return "Message sent";

    }
}



