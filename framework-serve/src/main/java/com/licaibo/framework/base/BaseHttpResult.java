package com.licaibo.framework.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * hhtp请求基本返回结构
 * @author licaibo
 * @date 2020-03-11
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseHttpResult<T> {

    /***
     * HTTP状态码
     */
    private Integer code;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

}
