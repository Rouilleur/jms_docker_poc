package com.rouilleur.jmsdockerpoc.receiver.listener;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverListener {


    @JmsListener(destination = "queue2.queue", containerFactory = "myQueueFactory")
    public void receiveFromQueue2(String message) {
        System.out.println("Received message on queue 2 : " + message);

    }

    @JmsListener(destination = "queue4.queue", containerFactory = "myQueueFactory")
    public void receiveFromQueue4(String message) {
        System.out.println("Received message on queue 4 : " + message);
    }

    @JmsListener(destination = "topic1.topic", containerFactory = "myTopicFactory")
    public void receiveAMessageTopic1(String message) {
        System.out.println("I just received a message on topic 1 : " + message);
    }

}
