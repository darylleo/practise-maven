package com.daryl.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wl
 * @create 2022-01-12
 */
@Component
public class MessageListener {

    @RabbitListener(queues = "item_queue")
    public void myListener1(String message){
        System.out.println("消费者接受到的消息为："+message);
    }

}
