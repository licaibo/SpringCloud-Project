package com.licaibo.framework.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本异常定义
 * @author licaibo
 * @date 2020-03-11
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicException extends RuntimeException {


    /***
     * HTTP状态码
     */
    private Integer code;

    /**
     * 异常描述信息
     */
    private String msg;


}
