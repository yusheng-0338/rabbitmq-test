package com.exam.spring.project.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "dircet.queue1"),
            exchange = @Exchange(name = "dircet.exchange", type = ExchangeTypes.DIRECT),
            key = {"aaa", "bbb"}
    ))
    public void listenDirectQueue1(String msg){
        System.out.println("接收到消息了:" + msg);
    }

}
