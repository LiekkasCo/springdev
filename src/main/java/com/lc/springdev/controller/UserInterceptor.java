package com.lc.springdev.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author liangchen
 */
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        log.info("拦截器");
        log.info("URI:{}",request.getRequestURI());
        if (request.getRequestURI().contains("/user")){
            log.info("拦截到了用户接口，停止");
            return false;
        }else {
            log.info("不是用户接口，继续");
            return true;
        }
    }
}
