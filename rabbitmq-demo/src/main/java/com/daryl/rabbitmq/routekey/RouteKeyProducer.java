package com.daryl.rabbitmq.routekey;

import com.daryl.util.MqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author wl
 * @create 2022-01-12
 */
public class RouteKeyProducer {
    public static void main(String[] args) throws Exception {
        Connection connection = MqUtil.getConnection();
        Channel channel = connection.createChannel();

        String exchange = "direct_exchange";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);

        String queueInsert = "direct_queue_insert";
        String queueUpdate = "direct_queue_update";
        channel.queueDeclare(queueInsert,true,false,false,null);
        channel.queueDeclare(queueUpdate,true,false,false,null);

        channel.queueBind(queueInsert, exchange, "insert");
        channel.queueBind(queueUpdate, exchange, "update");

        String insertMsg = "insert into table...";
        channel.basicPublish(exchange, "insert",null,insertMsg.getBytes());

        String updateMsg = "update table set...";
        channel.basicPublish(exchange, "update", null, updateMsg.getBytes());

        MqUtil.close(connection, channel);
    }
}
