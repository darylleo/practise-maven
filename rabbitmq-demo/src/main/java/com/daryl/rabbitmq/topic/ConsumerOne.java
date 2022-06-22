package com.daryl.rabbitmq.topic;

import com.daryl.util.MqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author wl
 * @create 2022-01-12
 */
public class ConsumerOne {
    public static void main(String[] args) throws Exception {
        Connection connection = MqUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("topic_queue_1", true, false, false, null);

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //路由key
                String routingKey = envelope.getRoutingKey();
                //交换机信息
                String exchange = envelope.getExchange();
                //消息id
                long deliveryTag = envelope.getDeliveryTag();
                //消息信息
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("routingKey--->" + routingKey);
                System.out.println("exchange--->" + exchange);
                System.out.println("deliveryTag--->" + deliveryTag);
                System.out.println("message--->" + message);
                System.out.println("-------END-------");
            }
        };

        channel.basicConsume("topic_queue_1", true, defaultConsumer);
    }
}
