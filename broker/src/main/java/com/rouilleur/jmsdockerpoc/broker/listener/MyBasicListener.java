package com.rouilleur.jmsdockerpoc.broker.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MyBasicListener {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public MyBasicListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @JmsListener(destination = "queue1.queue")
    public void receiveAMessage(String message){
        System.out.println("I just received a message on queue 1 : " + message);
    }

    @JmsListener(destination = "queue4.queue")
    public void receiveAMessageQueue4(String message){
        System.out.println("I just received a message on queue 4 : " + message);
    }


    @JmsListener(destination = "queue3.queue")
    public void receiveAMessageThenForward(String message){
        System.out.println("I just received a message on queue 3 : " + message);

        System.out.println("Forwarding on queue 2 : " + message);
        jmsTemplate.convertAndSend("queue2.queue","Message queue2 : (FW) " + message );
    }


}
