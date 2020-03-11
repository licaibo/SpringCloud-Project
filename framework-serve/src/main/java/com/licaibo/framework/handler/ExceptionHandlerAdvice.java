package com.licaibo.framework.handler;

import com.licaibo.framework.base.BaseHttpResult;
import com.licaibo.framework.enu.HttpResultEnum;
import com.licaibo.framework.exception.BasicException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 * @author licaibo
 * @date 2020-03-11
 **/
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BasicException.class)
    @ResponseBody
    public BaseHttpResult basicExceptionHandler(HttpServletRequest request, HttpServletResponse response, BasicException ex) {
        return BaseHttpResult.builder().code(ex.getCode()).msg(ex.getMsg()).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseHttpResult exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        return BaseHttpResult.builder().code(HttpResultEnum.UNKONW_ERROR.getCode()).msg(ex.toString()).build();
    }


}
