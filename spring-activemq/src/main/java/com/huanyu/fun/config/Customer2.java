package com.huanyu.fun.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//分裂
@Component
@RabbitListener(queues = "dufu")
public class Customer2 {
    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("分裂"+msg);
    }
}