package com.huberyzhao.activemq.consumer.controller;

import com.huberyzhao.activemq.consumer.service.ConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "消费者接口")
@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping("/handleQueue")
    @ApiOperation("队列消息消费")
    public String handleQueue(){
        try {
            return consumerService.consumerQueue();
        } catch (Exception e) {
            log.error("【错误】=",e.getMessage());
        }
        return "消息消费失败";
    }


    @PostMapping("/handleTopic")
    @ApiOperation("订阅消息消费")
    public String handleTopic(){
        try {
            return consumerService.consumerTopic();
        } catch (Exception e) {
            log.error("【错误】=",e.getMessage());
        }
        return "消息消费失败";
    }

}
