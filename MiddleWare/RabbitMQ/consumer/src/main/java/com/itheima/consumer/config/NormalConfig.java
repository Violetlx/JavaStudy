package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixuan
 * @Date 2024/9/2 14:25
 */
@Configuration
public class NormalConfig {

    /**
     * 声明交换机
     * @return Direct类型交换机
     */
    @Bean
    public DirectExchange normalExchange(){
        return ExchangeBuilder.directExchange("normal.direct").build();
    }

    /**
     * 第1个队列
     */
    @Bean
    public Queue normalQueue(){
        return QueueBuilder
                .durable("normal.queue")
                .deadLetterExchange("dlx.direct")
                .build();
    }

    /**
     * 绑定队列和交换机
     */
    @Bean
    public Binding bindingQueueWithRed(Queue normalQueue, DirectExchange normalExchange){
        return BindingBuilder.bind(normalQueue).to(normalExchange).with("hi");
    }
}
