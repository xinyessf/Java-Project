package com.huanyu.fun.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//直连
@Component
@RabbitListener(queues = "zhijie")
public class Customer1 {
    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("直联的啊:"+msg);
    }
}