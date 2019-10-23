package com.licaibo.provider.service;

import com.licaibo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by licaibo on 2017/9/30
 */
@Service
public class UserService {

//    @Autowired
//    private UserDao userDao;

    public User selectByName(String name) {
        User user = new User();
        user.setId(1);
        user.setName("test");
        user.setAddress("china");
        user.setAge(20);
        return user;
    }

}
