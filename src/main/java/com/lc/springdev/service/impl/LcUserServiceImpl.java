package com.lc.springdev.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.springdev.data.JsonResultCode;
import com.lc.springdev.data.exception.CustomException;
import com.lc.springdev.entity.LcUser;
import com.lc.springdev.mapper.LcUserMapper;
import com.lc.springdev.service.LcUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

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

    @Override
    public Boolean addOneUser(LcUser lcUser) {
        String name = lcUser.getName();
        String pattern = "[\u4e00-\u9fa5]+";
        boolean isMatch =  Pattern.matches(pattern, name);
        if (StringUtils.isBlank(lcUser.getName())){
            throw new CustomException(JsonResultCode.CODE_NAME_NOT_NULL);
        }
        log.info("新增一个用户,用户信息为:{}",lcUser);
        return lcUserMapper.addOneUser(lcUser)>0;
    }

    @Override
    public PageInfo<LcUser> getUserPageInfo() {
        //1.执行分页
        PageHelper.startPage(1,5);
        //2.执行查询
        List<LcUser> list = lcUserMapper.findAll();
        //3.封装pageInfo对象
        PageInfo<LcUser> pageInfo = new PageInfo<>(list);
        //4.输出
        return pageInfo;
    }
}
