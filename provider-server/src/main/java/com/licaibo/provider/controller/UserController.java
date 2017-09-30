package com.licaibo.provider.controller;


import com.licaibo.common.User;
import com.licaibo.provider.service.UserService;
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
    public User selectByName(@PathVariable String name) {
        return userService.selectByName(name);
    }

}
