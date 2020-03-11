package com.licaibo.framework.base;

import com.licaibo.framework.enu.HttpResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  基础Controller,用于返回规定格式的数据
 * @author licaibo
 * @date 2020-03-11
 **/
@Slf4j
@ResponseBody
public class BasicResultController {


    public static ResponseEntity responseOk(Object data) {
        BasicResult basicResult = BasicResult.builder().code(HttpResultEnum.SUCCESS.getCode()).msg(HttpResultEnum.SUCCESS.getMsg()).data(data).build();
        return ResponseEntity.status(HttpResultEnum.SUCCESS.getCode()).body(basicResult);
    }

    public static ResponseEntity responseOk() {
       return responseOk(null);
    }

    public static ResponseEntity responseError(Object data) {
        BasicResult basicResult = BasicResult.builder().code(HttpResultEnum.INTERNAL_SERVER_ERROR.getCode()).msg(HttpResultEnum.INTERNAL_SERVER_ERROR.getMsg()).data(data).build();
        return ResponseEntity.status(HttpResultEnum.INTERNAL_SERVER_ERROR.getCode()).body(basicResult);
    }

    public static ResponseEntity responseError() {
        return responseError(null);
    }


}
