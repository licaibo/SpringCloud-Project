package com.licaibo.auth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


/**
 * 重载loadUserByUsername方法，当用户登录时，会调用UserDetailsService接口的loadUserByUsername()来校验用户的合法性（密码和权限）
 * @author licaibo
 * @date 2019-12-25
 **/
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO 登陆时根据用户名查询用户信息,先临时判断一下
        if(!"admin".equals(username)) {
            throw new UsernameNotFoundException(username);
        } else {
            //TODO 存入redis

        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        return new User("admin",new BCryptPasswordEncoder().encode("123456"),authorities);
    }


}
