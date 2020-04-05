package com.licaibo.provider.order.service;

import com.licaibo.common.dto.UserInfo;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
public interface UserService {

    UserInfo selectByName(String name);

}
