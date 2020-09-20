package com.lc.springdev.controller;

import com.lc.springdev.entity.JwUser;
import com.lc.springdev.entity.User;
import com.lc.springdev.mapper.JwUserMapper;
import com.lc.springdev.properties.AliyunProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * test controller
 * @author liangchen
 * @date 2020.09.20
 */
@RestController
public class TestController {

    @Autowired
    protected User user;
    @Autowired
    private JwUserMapper jwUserMapper;
    @GetMapping("/test")
    public String test(){
        return "hello world";
    }

    @GetMapping("/user")
    public User user(){
        return user;
    }

    @Value("${picPath}")
    private String picPath;
    @GetMapping("/picPath")
    public String picPath(){
        return picPath;
    }

    @Autowired
    private AliyunProperties aliyunProperties;
    @GetMapping("/aliyun")
    public AliyunProperties getAliyunProperties(){
        return aliyunProperties;
    }

    @GetMapping("/jw")
    public List<JwUser> getAllJwUser(){
        return jwUserMapper.findAll();
    }
}
