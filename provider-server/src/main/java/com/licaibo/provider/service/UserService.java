package com.licaibo.provider.service;

import com.licaibo.provider.bean.User;
import com.licaibo.provider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by licaibo on 2017/9/30
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

}
