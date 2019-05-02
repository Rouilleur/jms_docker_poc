package com.rouilleur.jmsdockerpoc.emitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class EmittingApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmittingApplication.class, args);

    }

}



