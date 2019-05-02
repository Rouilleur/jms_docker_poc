package com.rouilleur.jmsdockerpoc.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;



@SpringBootApplication
@EnableJms
public class ReceivingApplication {

    public static void main(String[] args) {

        SpringApplication.run(ReceivingApplication.class, args);

    }

}



