package com.licaibo.framework.enu;


/**
 * 常用的HTTP状态码枚举 参考HttpStatus
 * @author licaibo
 * @date 2020-03-11
 **/
public enum HttpResultEnum {

    UNKONW_ERROR(-1, "Unkonw Error"),
    SUCCESS(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
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
