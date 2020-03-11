package com.licaibo.auth.security.handler;

import com.licaibo.framework.base.BasicResult;
import com.licaibo.framework.enu.HttpResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring security 用户登陆认证成功处理
 * @author licaibo
 * @date 2020-01-07
 **/
@Slf4j
@Service
public class MyAuthenctiationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        log.info("登录成功");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(BasicResult.builder().code(HttpResultEnum.SUCCESS.getCode()).msg("登陆成功").build().toString());
    }

}
