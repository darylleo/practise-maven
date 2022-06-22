package com.daryl.rabbitmq.work;

import com.daryl.util.MqUtil;

/**
 * @author wl
 * @create 2022-01-11
 */
public class WorkConsumer2 {
    public static void main(String[] args) throws Exception {
        String  queue = "work_queue";
        MqUtil.receiveMsg(queue);
    }
}
