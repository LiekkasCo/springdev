package com.lc.springdev.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis
 * @author liangchen
 */
@Slf4j
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host:127.0.0.1}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private int port;

    @Value("${spring.redis.timeout:0}")
    private int timeout;

    @Value("${spring.redis.pool.maxIdle:20}")
    private int maxIdle;

    @Value("${spring.redis.pool.maxTotal:100}")
    private int maxTotal;

    @Value("${spring.redis.pool.maxWaitMillis:-1}")
    private long maxWaitMillis;

    @Value("${spring.redis.password:#{null}}")
    private String password;

    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxTotal(maxTotal);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password);

        log.info("JedisPool注入成功！");
        log.info("redis地址：" + host + ":" + port);
        return  jedisPool;
    }
}
