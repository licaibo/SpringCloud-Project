package com.licaibo.consumer.controller;

import com.licaibo.common.User;
import com.licaibo.consumer.feign.ProviderFeign;
import com.licaibo.consumer.servicer.UserServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/30
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServicer userServicer;
    @Autowired
    private ProviderFeign providerFeign;

    /**
     * restTemplate调用
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    public User selectByName(@PathVariable String name) {
       return userServicer.selectByName(name).getBody();
    }

    /**
     * feign调用
     * @param name
     * @return
     */
    @GetMapping("/feign")
    public String selectByFeign(@RequestParam("name") String name) {
        return providerFeign.selectByFeign(name);
    }

}
