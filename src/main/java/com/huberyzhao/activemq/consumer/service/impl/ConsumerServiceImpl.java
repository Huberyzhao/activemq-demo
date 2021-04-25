package com.huberyzhao.activemq.consumer.service.impl;

import com.huberyzhao.activemq.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private  String message = "";

    private String topicMessage = "";

    @Override
    public String consumerQueue() {
        return "我是消费者，消费了huberyzhao-queue的消息：" + this.message;
    }

    @JmsListener(destination = "huberyzhao-queue",containerFactory = "queueListenerFactory") // 监听该消息队列
    @SendTo("消费成功") //将返回的消息写到另一个队列中间去
    private void queueMessage(String message){
        log.info("【queue消息】= " + message);
        this.message = message;
    }

    @Override
    public String consumerTopic() {
        return "我是消费者，消费了huberyzhao-topic的消息：" + this.topicMessage;
    }

    @JmsListener(destination = "huberyzhao-topic",containerFactory = "topicListenerFactory") // 监听该消息队列
//    @SendTo() 将返回的消息写到另一个队列中间去
    private void topocMessage(String message){
        log.info("【topic消息】= " + message);
        this.topicMessage = message;
    }
}
