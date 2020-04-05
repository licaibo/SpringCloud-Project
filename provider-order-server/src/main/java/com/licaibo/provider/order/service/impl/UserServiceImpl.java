package com.licaibo.provider.order.service.impl;

import com.licaibo.common.dto.UserInfo;
import com.licaibo.provider.order.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by licaibo on 2017/9/30
 */
@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    private UserDao userDao;

    @Override
    public UserInfo selectByName(String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfo.setUsername("test");
        userInfo.setPassword("china");
        return userInfo;
    }

}
