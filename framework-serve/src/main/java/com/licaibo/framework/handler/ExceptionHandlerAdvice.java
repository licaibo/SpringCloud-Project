package com.licaibo.framework.handler;

import com.licaibo.framework.base.BasicResult;
import com.licaibo.framework.enu.HttpResultEnum;
import com.licaibo.framework.exception.BasicException;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity basicExceptionHandler(HttpServletRequest request, HttpServletResponse response, BasicException ex) {
        return  ResponseEntity.status(ex.getCode()).body(BasicResult.builder().code(ex.getCode()).msg(ex.getMsg()).data(null).build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        return  ResponseEntity.status(HttpResultEnum.INTERNAL_SERVER_ERROR.getCode()).body(BasicResult.builder().code(HttpResultEnum.INTERNAL_SERVER_ERROR.getCode()).msg(ex.toString()).data(null).build());
    }


}
