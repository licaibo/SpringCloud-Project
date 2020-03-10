package com.licaibo.auth.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.licaibo.auth.security.UserLoginToke;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 *
 * spring security基于用户名和密码的认证过滤器，支持json提交和表单提交用户认证
 * @author licaibo
 * @date 2019-12-26
 * @href https://www.jianshu.com/p/693914564406
 **/
@Slf4j
public class MyUsernameAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private boolean postOnly = true;

    /**
     *  重载attemptAuthentication方法支持json提交和表单提交用户认证
     *  原生spring security attemptAuthentication方法只支持表单提交
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //json提交
        if(MediaType.APPLICATION_JSON_UTF8_VALUE.equals(request.getContentType()) || MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType())) {
            if (this.postOnly && !request.getMethod().equals("POST")) {
                throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
            }

            UsernamePasswordAuthenticationToken authRequestToken = null;
            try {
                ObjectMapper mapper = new ObjectMapper();
                InputStream inputStream = request.getInputStream();
                UserLoginToke userLoginToke = mapper.readValue(inputStream, UserLoginToke.class);
                authRequestToken = new UsernamePasswordAuthenticationToken(userLoginToke.getUsername(),userLoginToke.getPassword());
            } catch (Exception ex) {
                ex.printStackTrace();
                authRequestToken = new UsernamePasswordAuthenticationToken("","");
            } finally {
                this.setDetails(request, authRequestToken);
                return this.getAuthenticationManager().authenticate(authRequestToken);
            }

        }


        return super.attemptAuthentication(request,response);
    }




}
