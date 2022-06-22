package com.daryl.rabbitmq.topic;

import com.daryl.util.MqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author wl
 * @create 2022-01-12
 */
public class TopicProducer {
    public static void main(String[] args) throws Exception {
        Connection connection = MqUtil.getConnection();
        Channel channel = connection.createChannel();

        String exchange = "topic_exchange";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC);

        String queueOne = "topic_queue_1";
        String queueTwo = "topic_queue_2";
        channel.queueDeclare(queueOne, true, false, false, null);
        channel.queueDeclare(queueTwo, true, false, false, null);

        channel.queueBind(queueOne, exchange, "item.update");
        channel.queueBind(queueOne, exchange, "item.delete");
        channel.queueBind(queueTwo, exchange, "item.*");

        String insertMsg = "insert into table values...";
        channel.basicPublish(exchange, "item.insert", null, insertMsg.getBytes());

        String updateMsg = "update table set key = value...";
        channel.basicPublish(exchange, "item.update", null, updateMsg.getBytes());

        String deleteMsg = "delete from table ...";
        channel.basicPublish(exchange, "item.delete", null, deleteMsg.getBytes());


        MqUtil.close(connection, channel);
    }
}
