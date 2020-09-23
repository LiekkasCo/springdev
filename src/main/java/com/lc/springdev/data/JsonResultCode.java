package com.lc.springdev.data;

import lombok.Getter;
import lombok.ToString;

/**
 * code&message
 * @author liangchen
 * @date 2020.09.23
 */
@Getter
@ToString
public enum JsonResultCode {
    /**
     * 0成功 -1失败
     */
    CODE_SUCCESS(0,"成功"),
    CODE_FAIL(-1,"操作失败"),
    CODE_NAME_ONLY_CN(10001,"姓名只能为汉字");

    private int code;
    private String message;

    JsonResultCode(int code,String message){
        this.code = code;
        this.message = message;
    }
}
