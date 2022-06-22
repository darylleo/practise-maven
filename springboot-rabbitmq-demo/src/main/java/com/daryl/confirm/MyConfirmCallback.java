package com.daryl.confirm;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wl
 * @create 2022-01-12
 */
@Component
public class MyConfirmCallback implements RabbitTemplate.ConfirmCallback {
    /**
     *
     * @param correlationData 消息信息
     * @param b 确认标识，true:MQ服务器exchange表示已经确认收到消息，false表示没有收到消息
     * @param s 如果没有收到消息，则指定为mq服务器exchange消息没有收到的原因，如果已经收到，则指定为null
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b){
            System.out.println("发送消息到交换机成功" + s);
        }else {
            System.out.println("发送消息到交换机失败,原因是:" + s);
        }
    }
}
