package com.huanyu.fun.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//主题
@Component
@RabbitListener(queues = "laibai")
public class Customer3 {
    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("kudingyu"+msg);
    }
}