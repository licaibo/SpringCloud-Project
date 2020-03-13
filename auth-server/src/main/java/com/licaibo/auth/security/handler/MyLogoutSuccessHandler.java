package com.licaibo.auth.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.licaibo.framework.base.BasicResult;
import com.licaibo.framework.enu.HttpResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring security 用户登出成功处理
 * @author licaibo
 * @date 2020-03-11
 **/
@Slf4j
@Service
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //UserInfo user = (UserInfo) authentication.getPrincipal();
        //String username = user.getUsername();
        //log.info("username: {}  is offline now", username);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        BasicResult basicResult = BasicResult.builder().code(HttpResultEnum.SUCCESS.getCode()).msg("登出成功").build();
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(basicResult));
    }
}
