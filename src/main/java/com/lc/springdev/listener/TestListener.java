package com.lc.springdev.listener;

import com.lc.springdev.config.RabbitConfig;
import com.lc.springdev.service.RabbitService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 消费者
 * @author liangchen
 */
@Slf4j
//@Component
//@RabbitListener(queues = {RabbitConfig.QUEUE_TEST},ackMode ="MANUAL")

public class TestListener {
    @Autowired
    protected RabbitService rabbitService;

    @RabbitHandler
    @RabbitListener(queues = {RabbitConfig.QUEUE_TEST},ackMode ="MANUAL")

    public void testConsumer(Channel channel, Message message) throws IOException {
        try {
            log.info("消费者监听到测试消息队列：");
            rabbitService.doSomething();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {

            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("回复成功");
        }catch (Exception e){
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            log.info("回复失败");
        }

    }
}
