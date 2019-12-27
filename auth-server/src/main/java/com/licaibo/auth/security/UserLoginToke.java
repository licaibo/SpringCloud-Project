package com.licaibo.auth.security;

import lombok.Data;

/**
 * 用户名和密码，用于序列化登陆提交的json
 * @author licaibo
 * @date 2019-12-26
 **/
@Data
public class UserLoginToke {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
