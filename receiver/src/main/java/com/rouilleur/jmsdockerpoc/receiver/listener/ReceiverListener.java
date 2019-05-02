package com.rouilleur.jmsdockerpoc.receiver.listener;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverListener {



    @JmsListener(destination = "queue2.queue")
    public void receiveFromQueue2(String message){
        System.out.println("Received message on queue 2 : " + message);

    }


    @JmsListener(destination = "queue4.queue")
    public void receiveFromQueue4(String message){
        System.out.println("Received message on queue 4 : " + message);

    }

}
