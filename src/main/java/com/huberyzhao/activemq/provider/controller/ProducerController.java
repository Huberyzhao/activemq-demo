package com.huberyzhao.activemq.provider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@Api(tags = "生产者接口")
@RestController
@Slf4j
public class ProducerController {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    @PostMapping("/sendQueue")
    @ApiOperation("队列消息生产者")
    public String sendQueue(@RequestBody String message){
        try {
            jmsMessagingTemplate.convertAndSend(queue,message);
            return "消息发送成功";
        } catch (Exception e) {
            log.error("【错误】=",e.getMessage());
        }
        return "消息发布失败";
    }

    @PostMapping("/sendTopic")
    @ApiOperation("订阅消息生产者")
    public String sendTopic(@RequestBody String message){
        try {
            jmsMessagingTemplate.convertAndSend(topic,message);
            return "消息发布成功";
        } catch (Exception e) {
            log.error("【错误】=",e.getMessage());
        }
        return "消息发布失败";
    }

}
