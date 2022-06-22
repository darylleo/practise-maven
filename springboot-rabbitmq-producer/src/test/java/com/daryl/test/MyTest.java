package com.daryl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wl
 * @create 2022-01-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test01(){

        //rabbitTemplate.convertAndSend("666");
        rabbitTemplate.convertAndSend("item_topic_exchange","item.insert","新增，routingkey为itemInsert");
        rabbitTemplate.convertAndSend("item_topic_exchange","item.update","更新，routingkey为itemUpdate");
        rabbitTemplate.convertAndSend("item_topic_exchange","item.delete","删除，routingkey为itemDelete");
    }
}
