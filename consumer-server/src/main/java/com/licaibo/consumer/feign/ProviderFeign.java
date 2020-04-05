package com.licaibo.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用Provider-serve工程接口
 * @Author licaibo
 * @Date 2019-11-20
 **/
@Component
@FeignClient(name = "provider-order-server")
public interface ProviderFeign {


    @GetMapping("/inside/demo")
    String selectByFeign(@RequestParam("name") String name);


}
