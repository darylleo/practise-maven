package com.daryl.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @create 2022-01-12
 */
@RestController
@RequestMapping("/test")
public class TestApi {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitTemplate.ConfirmCallback myConfirmCallback;
    @Autowired
    private RabbitTemplate.ReturnCallback myReturnCallback;

    @RequestMapping("/send")
    public Object test() {
        //设置回调函数
        rabbitTemplate.setConfirmCallback(myConfirmCallback);
        rabbitTemplate.setReturnCallback(myReturnCallback);
        //发送消息
        rabbitTemplate.convertAndSend("exchange_direct_demo", "item.insertt", "insert into table values...");
        return "ok";
    }

    @RequestMapping("/send3")
    public Object test02() {
        //设置回调函数
        //rabbitTemplate.setConfirmCallback(myConfirmCallback);
        //rabbitTemplate.setReturnCallback(myReturnCallback);
        //发送消息
        rabbitTemplate.convertAndSend("exchange_direct_demo", "item.insert", "insert into table values...");
        return "ok";
    }
}
