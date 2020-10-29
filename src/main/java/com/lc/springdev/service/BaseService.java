package com.lc.springdev.service;

import com.lc.springdev.config.JedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * base service
 * @author liangchen
 */
@Service
public class BaseService {
    @Autowired
    public LcUserService lcUserService;
    @Autowired
    public JedisManager jedisManager;
    @Autowired
    public RabbitService rabbitService;
}
