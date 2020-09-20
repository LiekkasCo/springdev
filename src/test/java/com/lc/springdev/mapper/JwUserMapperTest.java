package com.lc.springdev.mapper;

import com.lc.springdev.SpringdevApplicationTests;
import com.lc.springdev.entity.JwUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


class JwUserMapperTest extends SpringdevApplicationTests {

    @Autowired
    private JwUserMapper jwUserMapper;
    @Test
    void findAll() {
        List<JwUser> list = jwUserMapper.findAll();
        for (JwUser jwUser : list) {
            System.out.println(jwUser);
        }
    }

    @Test
    void findOne() {
        JwUser one = jwUserMapper.findOne(1);
        System.out.println(one);
    }
}