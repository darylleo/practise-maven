package com.daryl.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wl
 * @create 2022-01-12
 */
@Component
@RabbitListener(queues = "queue_demo")
public class MyRabbitListener {

/*
    @RabbitHandler
    public void msg(String message) {
        System.out.println("消费Duang接受消息" + message);
    }
*/

    /*
    第一种：签收
        channel.basicAck();
    第二种：拒绝签收，批量处理
        channel.basicNack();
    第三种：拒绝签收，不批量处理
        channel.basicReject();
     */
    @RabbitHandler
    public void msg(Message message, Channel channel, String msg) {
        System.out.println("消费Duang接受消息" + msg);
        try {
            //业务处理
            System.out.println("开始业务处理----------------Start");
            Thread.sleep(5000);
            //int i = 10/0;
            System.out.println("业务处理结束----------------END");
            //签收消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            //如果出现异常，则拒绝消息，可以重回队列，也可以丢弃，根据业务场景来
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
