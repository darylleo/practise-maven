package com.daryl.rabbitmq.simple;

import com.daryl.util.MqUtil;


/**
 * 消息队列生产者
 *
 * @author wl
 * @create 2022-01-11
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        String queue = "simple_queue";
        String message = "coming";
        MqUtil.sendMsg(queue, message);
    }
}
