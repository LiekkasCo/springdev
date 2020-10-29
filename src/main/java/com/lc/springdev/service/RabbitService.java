package com.lc.springdev.service;

/**
 * @author liangchen
 */
public interface RabbitService {
    /**
     * 发送消息
     * @param exchange 交换机
     * @param routerKey 路由
     */
    void send(String exchange,String routerKey);

    /**
     * do something
     */
    void doSomething();
}
