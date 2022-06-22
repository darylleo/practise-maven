package com.daryl.rabbitmq.simple;

import com.daryl.util.MqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 消息队列消费者
 * @author wl
 * @create 2022-01-11
 */
public class Consumer {
    public static void main(String[] args) throws Exception{
        String queue = "simple_queue";
        MqUtil.receiveMsg(queue);
    }




    public void original() throws Exception{
        //创建链接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置RabbitMQ服务主机地址,默认localhost
        connectionFactory.setHost("localhost");
        //设置RabbitMQ服务端口,默认5672
        connectionFactory.setPort(5672);
        //设置虚拟主机名字，默认/
        connectionFactory.setVirtualHost("/daryl");
        //设置用户连接名，默认guest
        connectionFactory.setUsername("admin");
        //设置链接密码，默认guest
        connectionFactory.setPassword("123456");
        //创建链接
        Connection connection = connectionFactory.newConnection();
        //创建频道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare("simple_queue",true, false, false, null);
        //创建消费者，并设置消息处理
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            /**
             *
             * @param consumerTag 消费者标签，在channel.basicConsumer时候可以指定
             * @param envelope 消息包的内容，可以从中获取消息id，消息routingkey，交换机，消息和重传标志（收到消息失败后是否需要重新发送）
             * @param properties 属性消息
             * @param body 消息
             * @throws IOException io异常
             */
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
                System.out.println("routingKey"+routingKey);
                System.out.println("exchange"+exchange);
                System.out.println("deliveryTag"+deliveryTag);
                System.out.println("message"+message);
            }
        };
        //消息监听
        /**
         * 消息监听
         * 参数1：队列名称
         * 参数2：是否自动确认，设置为true表示消息接收到自动向mq回复接受到了，mq接收到回复会删除消息，设置为false则需要手动确认
         * 参数3：消息接收到后回调
         */
        channel.basicConsume("simple_queue",true,defaultConsumer );
        //关闭资源(不建议关闭，建议一直监听消息)
/*        channel.close();
        connection.close();*/
    }
}
