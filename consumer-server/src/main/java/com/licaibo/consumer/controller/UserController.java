package com.licaibo.consumer.controller;

import com.licaibo.common.User;
import com.licaibo.consumer.servicer.UserServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/9/30
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServicer userServicer;

    @GetMapping("/{name}")
    public User selectByName(@PathVariable String name) {
       return userServicer.selectByName(name).getBody();
    }

}
