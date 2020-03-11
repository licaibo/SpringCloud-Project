package com.licaibo.framework.enu;

/**
 * 状态码枚举
 * @author licaibo
 * @date 2020-03-11
 **/
public enum HttpResultEnum {

    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "请求错误"),
    FORBIDDEN(403, "权限错误"),
    FAIL(500,"服务器错误")
    ;


    private Integer code;

    private String msg;


    HttpResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }


}