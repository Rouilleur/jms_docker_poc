package com.rouilleur.jmsdockerpoc.broker.listener;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MyBasicListener {

    @JmsListener(destination = "input.queue")
    public void receiveAMessage(String message){
        System.out.println("I just received a message : " + message);
    }


}
