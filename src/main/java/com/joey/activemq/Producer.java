package com.joey.activemq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * 〈服务者〉
 *
 * @author Joey
 * @create 2019-01-28
 * @since 1.0.0
 */
@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

}
