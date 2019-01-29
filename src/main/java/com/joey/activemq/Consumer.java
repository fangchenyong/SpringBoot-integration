package com.joey.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 〈消费者〉
 *
 * @author Joey
 * @create 2019-01-29
 * @since 1.0.0
 */
@Component
public class Consumer {

    @JmsListener(destination = "myqueues")
    public void receiveMsg(String message){
        System.out.println("message:"+message);
    }
}
