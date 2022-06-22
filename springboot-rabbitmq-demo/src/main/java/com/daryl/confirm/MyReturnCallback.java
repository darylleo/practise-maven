package com.daryl.confirm;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wl
 * @create 2022-01-12
 */
@Component
public class MyReturnCallback implements RabbitTemplate.ReturnCallback {
    /**
     *
     * @param message 消息信息
     * @param i 退回的状态码
     * @param s 退回的信息
     * @param s1 交换机
     * @param s2 路由key
     */
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("退回的消息是：" + new String(message.getBody()));
        System.out.println("退回的状态码是" + i);
        System.out.println("退回的信息是" + s);
        System.out.println("退回的交换机是" + s1);
        System.out.println("退回的routingKey是" + s2);
    }
}
