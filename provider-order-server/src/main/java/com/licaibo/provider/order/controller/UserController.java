package com.licaibo.provider.order.controller;


import com.licaibo.common.dto.UserInfo;
import com.licaibo.provider.order.service.UserService;
import com.licaibo.provider.order.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by licaibo on 2017/9/30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{name}")
    public UserInfo selectByName(@PathVariable String name) {
        return userService.selectByName(name);
    }

}
