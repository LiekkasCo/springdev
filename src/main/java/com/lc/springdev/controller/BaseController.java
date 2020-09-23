package com.lc.springdev.controller;


import com.lc.springdev.data.JsonResult;
import com.lc.springdev.data.JsonResultCode;
import com.lc.springdev.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * base controller
 * @author liangchen
 * @date 2020.09.23
 */
public class BaseController {
    @Autowired
    public BaseService baseService;
    public BaseService service(){
        return baseService;
    }

    public JsonResult getResult(JsonResultCode jsonResultCode,Object content){
        return (new JsonResult()).getResult(jsonResultCode, content);
    }

    public JsonResult success(){
        return getResult(JsonResultCode.CODE_SUCCESS,null);
    }
    public JsonResult success(Object content){
        return getResult(JsonResultCode.CODE_SUCCESS,content);
    }

    public JsonResult fail(){
        return getResult(JsonResultCode.CODE_FAIL,null);
    }
    public JsonResult fail(Object content){
        return getResult(JsonResultCode.CODE_FAIL,content);
    }
    public JsonResult fail(JsonResultCode jsonResultCode){
        return getResult(jsonResultCode,null);
    }
    public JsonResult fail(JsonResultCode jsonResultCode,Object content){
        return getResult(jsonResultCode,content);
    }
}
