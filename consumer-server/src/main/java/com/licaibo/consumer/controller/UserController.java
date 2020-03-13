package com.licaibo.consumer.controller;

import com.licaibo.common.dto.UserInfo;
import com.licaibo.consumer.feign.ProviderFeign;
import com.licaibo.consumer.servicer.UserServicer;
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
    private UserServicer userServicer;
    @Autowired
    private ProviderFeign providerFeign;

    /**
     * restTemplate调用
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    public UserInfo selectByName(@PathVariable String name) {
        log.info("restTemplate调用");
        return userServicer.selectByName(name).getBody();
    }

    /**
     * feign调用
     * @param name
     * @return
     */
    @GetMapping("/feign")
    public String selectByFeign(@RequestParam("name") String name) {
        log.info("feign调用");
        return providerFeign.selectByFeign(name);
    }

}
