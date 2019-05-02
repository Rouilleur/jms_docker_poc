package com.rouilleur.jmsdockerpoc.emitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsEmitterController {


    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsEmitterController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }



    //queue 1 : red by broker
    //get qui envoie -> c'est mal !!!
    @GetMapping("/sendMessageQueue1")
    public String sendMessageQueue1(@RequestParam(required = false) String input){

        System.out.println("Sending a message (Queue1)");
        jmsTemplate.convertAndSend("queue1.queue","Message queue1 : " + input );
        return "Message sent (Queue1) : " + input;
    }



    //Queue 2 : red by receiver
    @GetMapping("/sendMessageQueue2")
    public String sendMessageQueue2(@RequestParam(required = false) String input){
        System.out.println("Sending a message (Queue2)");
        jmsTemplate.convertAndSend("queue2.queue","Message queue2 : " + input );
        return "Message sent (Queue2) : " + input;
    }


    //Queue 3 : red by broker then forwarded
    @GetMapping("/sendMessageQueue3")
    public String sendMessageQueue3(@RequestParam(required = false) String input){
        System.out.println("Sending a message (Queue3)");
        jmsTemplate.convertAndSend("queue3.queue","Message queue3 : " + input );
        return "Message sent (Queue3) : " + input;
    }



    //Queue 4 : red by receiver + broker
    @GetMapping("/sendMessageQueue4")
    public String sendMessageQueue4(@RequestParam(required = false) String input){

        System.out.println("Sending a message (Queue4)");
        jmsTemplate.convertAndSend("queue4.queue","Message queue4 : " + input );
        return "Message sent (Queue4) : " + input;
    }



}



