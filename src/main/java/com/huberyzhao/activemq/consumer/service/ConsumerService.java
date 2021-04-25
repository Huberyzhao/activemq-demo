package com.huberyzhao.activemq.consumer.service;

import org.springframework.stereotype.Service;

@Service
public interface ConsumerService {

    /**
     * 消费消息队列
     *
     * @return 消息
     */
    String consumerQueue();


    /**
     * 消费订阅消息
     *
     * @return 消息
     */
    String consumerTopic();

}
