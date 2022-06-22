package com.daryl.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wl
 * @create 2022-01-12
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 声明交换机
     *
     * @return topic 交换机
     */
    @Bean
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange("item_topic_exchange").durable(true).build();
    }

    @Bean
    public Queue itemQueue() {
        return QueueBuilder.durable("item_queue").build();
    }

    @Bean
    public Binding itemQueueExchange(@Qualifier(value = "itemQueue") Queue queue, @Qualifier("topicExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("item.#").noargs();
    }
}
