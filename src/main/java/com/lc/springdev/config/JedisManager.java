package com.lc.springdev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * jedis工具
 * @author liangchen
 */
@Component
public class JedisManager {
    @Autowired
    public JedisPool pool;
    /**
     * 获取缓存连接池
     *
     * @return
     */
    public JedisPool getJedisPool() {
        return pool;
    }
    /**
     * 按时间设置缓存
     *
     * @param key
     * @param value
     * @param seconds
     */
    public void set(String key, String value, int seconds) {
        try (Jedis jedis = getJedisPool().getResource()) {
            jedis.set(key, value);
            jedis.expire(key, seconds);
        }
    }

    /**
     * 永久设置缓存
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        try (Jedis jedis = getJedisPool().getResource()) {
            jedis.set(key, value);
        }
    }

    /**
     * 删除key的缓存
     *
     * @param key
     */
    public void delete(String key) {
        try (Jedis jedis = getJedisPool().getResource()) {
            jedis.del(key);
        }
    }

    /**
     * 得到key的缓存
     *
     * @param key
     * @return
     */
    public String get(String key) {
        try (Jedis jedis = getJedisPool().getResource()) {
            return jedis.get(key);
        }
    }

    public void addToHash(String key, Map<String, String> data) {
        try (Jedis jedis = getJedisPool().getResource()) {
            jedis.hmset(key, data);
        }
    }
    public Map<String, String> getAllHash(String key) {
        try (Jedis jedis = getJedisPool().getResource()) {
            return jedis.hgetAll(key);
        }
    }
    public String getOneHash(String key, String filed){
        try (Jedis jedis = getJedisPool().getResource()) {
            return jedis.hget(key, filed);
        }
    }
}
