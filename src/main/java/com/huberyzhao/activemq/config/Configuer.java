package com.huberyzhao.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class Configuer {

    /**
     * 队列模式
     *
     * @return 队列主题
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("huberyzhao-queue");
    }

    /**
     * 订阅模式
     *
     * @return 订阅主题
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("huberyzhao-topic");
    }



    @Bean
 public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
   DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
   factory.setPubSubDomain(false);
   factory.setConnectionFactory(connectionFactory);
   return factory;
 }
 @Bean
 public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
   DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
   factory.setPubSubDomain(true);
   factory.setConcurrency("1");
   factory.setConnectionFactory(connectionFactory);
   return factory;
 }
}
