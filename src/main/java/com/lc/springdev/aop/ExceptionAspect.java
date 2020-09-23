package com.lc.springdev.aop;

import com.lc.springdev.controller.BaseController;
import com.lc.springdev.data.JsonResult;
import com.lc.springdev.data.JsonResultCode;
import com.lc.springdev.data.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * exception aspect
 * @author liangchen
 * @date 2020.09.23
 */
@Slf4j
@Aspect
@Component
public class ExceptionAspect {
    @Pointcut("execution(public com.lc.springdev.data.JsonResult com.lc.springdev.controller..*Controller.*(..))")
    public void controllerException(){}

//    @Around( value = "controllerException()")
//    public JsonResult handleException(ProceedingJoinPoint point) throws Throwable{
//        log.info("进入切面");
//        JsonResult result;
//        try {
//            result = (JsonResult) point.proceed();
//        }catch (Throwable e){
//            if (e instanceof CustomException) {
//                log.error("CustomException   :",e.getCause());
//                throw e;
//            }
//            return new JsonResult().fail(JsonResultCode.CODE_FAIL);
//        }
//        return result;
//    }
}
