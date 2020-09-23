package com.lc.springdev.controller;

import com.lc.springdev.data.JsonResult;
import com.lc.springdev.data.JsonResultCode;
import com.lc.springdev.data.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author laingchen
 * @date 2020.09.23
 */

@Slf4j
@RestControllerAdvice
public class ExceptionControllerHandler extends BaseController {


    @ExceptionHandler(CustomException.class)
    public JsonResult dealWithException(CustomException exception) {
        JsonResultCode code = exception.getJsonResultCode();
        if (null == code) {
            code = JsonResultCode.CODE_FAIL;
        }
        JsonResult fail;
        String errorMessage = exception.getMessage();
        if (StringUtils.isNotEmpty(errorMessage)) {
            fail = this.fail(code,errorMessage);
        }else {
                fail=this.fail(code);
        }
        Object[] args = exception.getArgs();
        if (null != args && args.length > 0) {
            fail = this.fail(code, args);
        }
        return fail;
    }
}
