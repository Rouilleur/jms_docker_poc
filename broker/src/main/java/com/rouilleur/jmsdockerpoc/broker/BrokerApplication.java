package com.rouilleur.jmsdockerpoc.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class BrokerApplication {


    public static void main(String[] args) {
        SpringApplication.run(BrokerApplication.class, args);

    }

}
