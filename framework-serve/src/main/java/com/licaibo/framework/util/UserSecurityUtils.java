package com.licaibo.framework.util;

import com.licaibo.common.dto.UserInfo;

/**
 * 登陆用户Spring Security相关，获取登陆用户信息
 * @author licaibo
 * @date 2020-03-13
 **/
public class UserSecurityUtils {

    /**
     * 获取当前登陆用户信息
     * @return
     */
    public static UserInfo getUser() {
        //TODO fegin调用AUTH获取当前用户信息
        return UserInfo.builder().build();
    }


}
