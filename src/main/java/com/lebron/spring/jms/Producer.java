package com.lebron.spring.jms;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装  
    private JmsMessagingTemplate messageTemplate;
    
    public void sendQueue(Destination destination,String msg){
        System.out.println("Producer :" + msg);
        messageTemplate.convertAndSend(destination, msg);
    }
    
    public void sendTopic(Destination destination,String msg){
        System.out.println("Producer :" + msg);
        messageTemplate.convertAndSend(destination, msg);
    }
    
}
