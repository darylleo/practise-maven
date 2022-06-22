package com.daryl.rabbitmq.ps;

import com.daryl.util.MqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author wl
 * @create 2022-01-12
 */
public class PublishSubscribeProducer {
    public static void main(String[] args) throws Exception {
        Connection connection = MqUtil.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 声明交换机
         * 参数1：交换机名称
         * 参数2：交换机类型
         */
        channel.exchangeDeclare("fanout_exchange", BuiltinExchangeType.FANOUT);
        /**
         * 声明队列
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其他参数
         */
        channel.queueDeclare("fanout_queue_1", true, false, false,  null);
        channel.queueDeclare("fanout_queue_2", true, false, false,  null);

        //队列绑定交换机
        channel.queueBind("fanout_queue_1", "fanout_exchange", "");
        channel.queueBind("fanout_queue_2", "fanout_exchange", "");

        String message = "888888888888888888888888888";

        /**
         * 参数1：交换机名称
         * 参数2：路由key，简单模式可以传递队列名称
         * 参数3：消息其他属性
         * 参数4：消息内容
         */
        channel.basicPublish("fanout_exchange", "", null, message.getBytes());
        MqUtil.close( connection, channel);
    }
}
