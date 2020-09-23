package com.lc.springdev.service.impl;

import com.lc.springdev.entity.LcUser;
import com.lc.springdev.mapper.LcUserMapper;
import com.lc.springdev.service.LcUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user dao impl
 * @author liangchen
 */
@Service
@Slf4j
public class LcUserServiceImpl implements LcUserService {
    @Autowired
    public LcUserMapper lcUserMapper;
    @Override
    public List<LcUser> getAll() {
        log.info("查询所有用户信息");
        return lcUserMapper.findAll();
    }

    @Override
    public LcUser getOne(long id) {
        log.info("查询id为:{}的用户信息",id);
        return lcUserMapper.findOne(id);
    }
}
