package com.licaibo.provider.service;

import com.licaibo.common.dto.UserInfo;
import org.springframework.stereotype.Service;

/**
 * Created by licaibo on 2017/9/30
 */
@Service
public class UserService {

//    @Autowired
//    private UserDao userDao;

    public UserInfo selectByName(String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfo.setUsername("test");
        userInfo.setPassword("china");
        return userInfo;
    }

}
