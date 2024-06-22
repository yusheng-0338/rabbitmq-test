package com.exam.spring.project.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获取RabbitTemplate
        RabbitTemplate rabbitTemplate =applicationContext.getBean(RabbitTemplate.class);
        //设置ReturnCallback
/*        rabbitTemplate.setReturnsCallback((message,replyCode,replyText,exchage,rotingKey)->{
            System.out.println("发送消息失败:"+"答应码"+message+"原因"+replyCode+"交换机"+replyText+"路由键"+exchage+"消息"+message.toString());
        });*/

        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("发送消息失败:" + "答应码" + returnedMessage.getReplyCode()
                        + "return原因" + returnedMessage.getReplyText()
                        + "交换机" + returnedMessage.getExchange()
                        + "路由键" + returnedMessage.getRoutingKey()
                        + "消息" + returnedMessage.getMessage());
            }
        });
    }
}
