package com.lebron.spring.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    
    @JmsListener(destination="queue1")
    @SendTo("queue2")//转发到其他Queue
    public String receiverQueue1(String msg){
        System.out.println("Queue1 receiver msg:" +msg);
        return "Comsumer UpperCase " + msg.toUpperCase();
    }

    @JmsListener(destination="queue2")
    public void receiverQueue2(String msg){
        System.out.println("Queue2 receiver msg:" +msg);
    }
    
    @JmsListener(destination="topic")
    public void receiverTopic1(String msg){
        System.out.println("Topic1 receiver msg:" + msg);
    }

    @JmsListener(destination="topic")
    public void receiverTopic2(String msg){
        System.out.println("Topic2 receiver msg:" + msg);
    }
}
