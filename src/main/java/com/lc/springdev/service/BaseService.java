package com.lc.springdev.service;

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
}
