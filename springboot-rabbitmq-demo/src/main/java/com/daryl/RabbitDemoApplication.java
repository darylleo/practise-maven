package com.daryl;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author wl
 * @create 2022-01-12
 */
@SpringBootApplication
public class RabbitDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitDemoApplication.class, args);
    }

    @Bean
    public Queue createQueue(){
        return new Queue("queue_demo");
    }

    @Bean
    public Exchange createExchange(){
        return new DirectExchange("exchange_direct_demo");
    }

    @Bean
    public Binding createBinding(){
        return BindingBuilder.bind(createQueue()).to(createExchange()).with("item.insert").noargs();
    }
}
