package com.licaibo.consumer.controller;

import com.licaibo.common.dto.UserInfo;
import com.licaibo.consumer.feign.ProviderOrderFeign;
import com.licaibo.consumer.servicer.UserService;
import com.licaibo.consumer.servicer.impl.UserServicerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/30
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProviderOrderFeign providerOrderFeign;

    /**
     * restTemplate调用
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    public UserInfo selectByName(@PathVariable String name) {
        log.info("restTemplate调用");
        return userService.selectByName(name).getBody();
    }

    /**
     * feign调用
     * @param name
     * @return
     */
    @GetMapping("/feign")
    public String selectByFeign(@RequestParam("name") String name) {
        log.info("feign调用");
        return providerOrderFeign.selectByFeign(name);
    }

}
