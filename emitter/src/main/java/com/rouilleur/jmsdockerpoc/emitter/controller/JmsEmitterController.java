package com.rouilleur.jmsdockerpoc.emitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsEmitterController {


    private final JmsTemplate jmsTemplateQueue;
    private final JmsTemplate jmsTemplateTopic;

    @Autowired
    public JmsEmitterController(@Qualifier("queue") JmsTemplate jmsTemplateQueue, @Qualifier("topic") JmsTemplate jmsTemplateTopic) {
        this.jmsTemplateQueue = jmsTemplateQueue;
        this.jmsTemplateTopic = jmsTemplateTopic;
    }


    //queue 1 : red by broker
    //get qui envoie -> c'est mal !!!
    @GetMapping("/sendMessageQueue1")
    public String sendMessageQueue1(@RequestParam(required = false) String input) {

        System.out.println("Sending a message (Queue1)");
        jmsTemplateQueue.convertAndSend("queue1.queue", "Message queue1 : " + input);
        return "Message sent (Queue1) : " + input;
    }


    //Queue 2 : red by receiver
    @GetMapping("/sendMessageQueue2")
    public String sendMessageQueue2(@RequestParam(required = false) String input) {
        System.out.println("Sending a message (Queue2)");
        jmsTemplateQueue.convertAndSend("queue2.queue", "Message queue2 : " + input);
        return "Message sent (Queue2) : " + input;
    }


    //Queue 3 : red by broker then forwarded
    @GetMapping("/sendMessageQueue3")
    public String sendMessageQueue3(@RequestParam(required = false) String input) {
        System.out.println("Sending a message (Queue3)");
        jmsTemplateQueue.convertAndSend("queue3.queue", "Message queue3 : " + input);
        return "Message sent (Queue3) : " + input;
    }


    //Queue 4 : red by receiver + broker
    @GetMapping("/sendMessageQueue4")
    public String sendMessageQueue4(@RequestParam(required = false) String input) {

        System.out.println("Sending a message (Queue4)");
        jmsTemplateQueue.convertAndSend("queue4.queue", "Message queue4 : " + input);
        return "Message sent (Queue4) : " + input;
    }


    //Topic 1 : red by receiver + broker
    @GetMapping("/sendMessageTopic1")
    public String sendMessageTopic1(@RequestParam(required = false) String input) {

        System.out.println("Sending a message (Topic 1)");
        jmsTemplateTopic.convertAndSend("topic1.topic", "Message topic1 : " + input);
        return "Message sent (topic1) : " + input;
    }


}



