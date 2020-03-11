package com.licaibo.auth.security.handler;

import com.licaibo.framework.base.BasicResult;
import com.licaibo.framework.enu.HttpResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring security 用户登陆认证失败处理
 * @author licaibo
 * @date 2020-01-07
 **/
@Slf4j
@Service
public class MyAuthenctiationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationException) throws IOException {
        log.info("用户登录失败");
        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(BasicResult.builder().code(HttpResultEnum.INTERNAL_SERVER_ERROR.getCode()).msg("用户名或密码错误").build().toString());
    }


}
