package com.rouilleur.jmsdockerpoc.emitter.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

    @Value("${spring.activemq.broker-url}")
    String BROKER_URL = "tcp://localhost:61616";

    @Value("${spring.activemq.user}")
    String BROKER_USERNAME = "admin";

    @Value("${spring.activemq.password}")
    String BROKER_PASSWORD = "admin";


    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL);
        connectionFactory.setPassword(BROKER_USERNAME);
        connectionFactory.setUserName(BROKER_PASSWORD);
        return connectionFactory;
    }

    @Bean
    @Qualifier("queue")
    public JmsTemplate jmsTemplateQueue() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }


    @Bean
    @Qualifier("topic")
    public JmsTemplate jmsTemplateTopic() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setPubSubDomain(true);
        return template;
    }

}
