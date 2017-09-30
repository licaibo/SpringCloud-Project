package com.licaibo.provider.controller;

import com.licaibo.provider.bean.User;
import com.licaibo.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by licaibo on 2017/9/30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{name}")
    public User selectByName(@PathVariable String name) {
        return userService.selectByName(name);
    }

}
