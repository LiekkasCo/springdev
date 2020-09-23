package com.lc.springdev.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一出参类型为json
 * @author liangchen
 * @date 2020.09.23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult {
    private int code;
    private String message;
    private Object content;

    public JsonResult getResult(JsonResultCode jsonResultCode,Object content){
        this.code = jsonResultCode.getCode();
        this.message = jsonResultCode.getMessage();
        this.content = content;
        return this;
    }
}
