package com.lc.springdev.data.exception;

import com.lc.springdev.data.JsonResultCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * custom exception
 * @author liangchen
 * @date 2020.09.23
 */
@Getter
@Setter
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private JsonResultCode jsonResultCode;
    private Object[] args;

    public CustomException(JsonResultCode jsonResultCode){
        this.jsonResultCode = jsonResultCode;
    }

    public CustomException(JsonResultCode jsonResultCode,Object ...args){
        this.jsonResultCode = jsonResultCode;
        this.args = args;
    }
}
