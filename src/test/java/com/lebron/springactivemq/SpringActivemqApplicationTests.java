package com.lebron.springactivemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lebron.spring.SpringActivemqApplication;
import com.lebron.spring.jms.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringActivemqApplication.class)
public class SpringActivemqApplicationTests {

    @Autowired
    private Producer producer;
    
	@Test
	public void contextLoads() {
	    //需要关闭spring.jms.pub-sub-domain配置
	    ActiveMQQueue queue = new ActiveMQQueue("queue1");
	    producer.sendQueue(queue, "lebron");
	    
	    //需要开启spring.jms.pub-sub-domain配置	    
	    ActiveMQTopic topic = new ActiveMQTopic("topic");
	    producer.sendTopic(topic, "chen");
	}

}
