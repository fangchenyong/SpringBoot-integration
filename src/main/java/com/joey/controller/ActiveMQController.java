package com.joey.controller;

import com.joey.activemq.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

/**
 * 〈控制器〉
 *
 * @author Joey
 * @create 2019-01-29
 * @since 1.0.0
 */
@Controller
public class ActiveMQController {

    @Autowired
    private Producer producer;

    @RequestMapping("/activemq")
    @ResponseBody
    public String tests(){
        Destination destination = new ActiveMQQueue("myqueues");
        for (int i=1;i<=3;i++) {
            producer.sendMessage(destination, "hello world! 第"+i+"次");
        }
        return "success";
    }
}
