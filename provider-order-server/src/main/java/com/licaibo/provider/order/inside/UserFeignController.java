package com.licaibo.provider.order.inside;

import org.springframework.web.bind.annotation.*;

/**
 * 内部接口，fegin调用
 * @Author licaibo
 * @Date 2019-11-20
 **/
@RestController
@RequestMapping("/inside")
public class UserFeignController {



    @GetMapping("/demo")
    public String selectByName(@RequestParam("name") String name) {
        return "hello feign : " + name;
    }


}
