package com.lc.springdev.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbitMq配置
 * @author liangchen
 */
@Configuration
public class RabbitConfig {
    /**
     * 队列
     */
    public static final String QUEUE_TEST = "queue.test";
    /**
     * 交换机
     */
    public static final String DIRECT_EXCHANGE_TEST = "exchange.test";
    /**
     * 路由
     */
    public static final String ROUTER_KEY_TEST = "key.test";

    /**
     * queue
     * @return queue
     */
    @Bean
    public Queue getTestQueue(){
        return new Queue(QUEUE_TEST,true);
    }

    /**
     * exchange
     * @return exchange
     */
    @Bean
    public DirectExchange getTestExchange(){
        return new DirectExchange(DIRECT_EXCHANGE_TEST,true,false);
    }

    @Bean
    public Binding testBanding(){
        return BindingBuilder.bind(getTestQueue()).to(getTestExchange()).with(ROUTER_KEY_TEST);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory currentSimpleRabbitListenerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory  = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(5);
        factory.setPrefetchCount(5);
        factory.setConnectionFactory(connectionFactory);
        //开启手动 ack
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return factory;
    }
}
