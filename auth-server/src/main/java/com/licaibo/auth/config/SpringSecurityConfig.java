package com.licaibo.auth.config;

import com.licaibo.auth.security.filter.MyUsernameAuthenticationFilter;
import com.licaibo.auth.security.handler.MyAuthenctiationFailureHandler;
import com.licaibo.auth.security.handler.MyAuthenctiationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SpringSecurity 配置
 *
 * @author licaibo
 * @date 2019-12-20
 * @href https://www.jianshu.com/p/693914564406
 **/
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("myUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;
    @Autowired
    private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;
    @Autowired
    private MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * authorizeRequests : 允许基于使用HttpServletRequest限制访问
         * 匹配登陆接口 /login** 不需要认证授权
         * csrf ： 关闭默认开启的跨域保护
         */
        http.authorizeRequests()
                .antMatchers("/login**").permitAll()
                .anyRequest().authenticated()
                //这里必须要写formLogin()，不然原有的UsernamePasswordAuthenticationFilter不会出现，也就无法配置我们重新的MyUsernameAuthenticationFilter
                .and().formLogin()
                .and().csrf().disable();

        // 用重写的Filter替换掉原有的UsernamePasswordAuthenticationFilter
        http.addFilterAt(myUsernameAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    /**
     * 注册自定义的MyUsernameAuthenticationFilter用户名密码认证过滤器，支持json提交和表单提交用户认证
     */
    @Bean
    MyUsernameAuthenticationFilter myUsernameAuthenticationFilter() throws Exception {
        MyUsernameAuthenticationFilter filter = new MyUsernameAuthenticationFilter();
        //自定义过滤器 成功和失败的处理
        filter.setAuthenticationSuccessHandler(myAuthenctiationSuccessHandler);
        filter.setAuthenticationFailureHandler(myAuthenctiationFailureHandler);
        filter.setFilterProcessesUrl("/login");
        //filter.setUsernameParameter("username");
        //filter.setPasswordParameter("password");

        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Autowired
//    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("123456"))
//                .roles("USER");
//    }

    /**
     * 自定义 userDetailsService 从数据库查询用户信息进行认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    /**
     * 密码加密格式  Spring security 5.0需要指定加密格式，不然会抛There is no PasswordEncoder mapped for the id "null"
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
