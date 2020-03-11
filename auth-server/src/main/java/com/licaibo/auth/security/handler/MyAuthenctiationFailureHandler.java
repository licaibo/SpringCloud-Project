package com.licaibo.auth.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.licaibo.framework.base.BasicResult;
import com.licaibo.framework.enu.HttpResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationException) throws IOException {
        log.info("用户登录失败");
        httpServletResponse.setStatus(HttpResultEnum.UNAUTHORIZED.getCode());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        BasicResult basicResult = BasicResult.builder().code(HttpResultEnum.UNAUTHORIZED.getCode()).msg("用户名或密码错误,请重新登陆!").build();
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(basicResult));
    }


}
