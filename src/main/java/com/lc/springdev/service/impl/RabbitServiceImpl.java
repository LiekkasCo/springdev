package com.lc.springdev.service.impl;

import com.lc.springdev.service.RabbitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 生产者
 * @author liangchen
 */
@Service
@Slf4j
public class RabbitServiceImpl implements RabbitService
//        ,RabbitTemplate.ConfirmCallback
{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String exchange, String routerKey) {
        log.info("队列消息生产者");
        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setConfirmCallback(this);
//        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.convertAndSend(exchange,routerKey,"test content");
    }
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println("CallBackConfirm UUID: " + correlationData.getId());
//
//        if(ack) {
//            System.out.println("CallBackConfirm 消息消费成功！");
//        }else {
//            System.out.println("CallBackConfirm 消息消费失败！");
//        }
//
//        if(cause!=null) {
//            System.out.println("CallBackConfirm Cause: " + cause);
//        }
//    }

    @Override
    public void doSomething() {
        log.info("进入消费者测试方法中");
    }

}
