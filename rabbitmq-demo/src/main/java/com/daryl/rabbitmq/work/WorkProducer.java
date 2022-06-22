package com.daryl.rabbitmq.work;

import com.daryl.util.MqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author wl
 * @create 2022-01-11
 */
public class WorkProducer {
    public static void main(String[] args) throws Exception {
        //创建链接
        Connection connection = MqUtil.getConnection();

        //创建频道
        Channel channel = connection.createChannel();

        /**
         * 声明队列
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其它参数
         * **/
        channel.queueDeclare("work_queue",true,false,false,null);

        for (int i = 0; i < 20; i++) {
            String message = "Daryl For Ever"+i;
            channel.basicPublish("","work_queue",null,message.getBytes());
        }

        //关闭资源
        channel.close();
        connection.close();
    }
}
