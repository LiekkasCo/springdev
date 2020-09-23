package com.lc.springdev.controller;

import com.lc.springdev.data.JsonResult;
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
public class TestController extends BaseController{

    @Autowired
    protected User user;
    @Autowired
    private JwUserMapper jwUserMapper;
    @Autowired
    private AliyunProperties aliyunProperties;

    @GetMapping("/test")
    public JsonResult test(){
        return success("hello world");
    }

    @GetMapping("/user")
    public JsonResult user(){
        return success(user);
    }

    @Value("${picPath}")
    private String picPath;
    @GetMapping("/picPath")
    public JsonResult picPath(){
        return success(picPath);
    }

    @GetMapping("/aliyun")
    public JsonResult getAliyunProperties(){
        return success(aliyunProperties);
    }

    @GetMapping("/jw")
    public JsonResult getAllJwUser(){
        return success(jwUserMapper.findAll());
    }
}
