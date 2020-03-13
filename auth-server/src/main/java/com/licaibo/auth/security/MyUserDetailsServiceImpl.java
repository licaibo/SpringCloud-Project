package com.licaibo.auth.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



/**
 * 重载loadUserByUsername方法，当用户登录时，会调用UserDetailsService接口的loadUserByUsername()来校验用户的合法性（密码和权限）
 * @author licaibo
 * @date 2019-12-25
 **/
@Service
@Slf4j
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户 : {} 执行登陆",username);
        //TODO 登陆时根据用户名查询用户信息,先临时判断一下
        String usernameTemp = "admin";
        String passwordTemp = "123456";

        if(!usernameTemp.equals(username)) {
            throw new UsernameNotFoundException(username);
        } else {
            //TODO 存入redis

        }

        return MyUserDetails.builder().username(usernameTemp).password(new BCryptPasswordEncoder().encode(passwordTemp)).build();
    }


}
