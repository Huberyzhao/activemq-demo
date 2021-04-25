package com.huberyzhao.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms //开启消息队列
public class ActivemqDomoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqDomoApplication.class, args);
    }

}
