package com.licaibo.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用Provider-stock-serve订单工程接口
 * @author licaibo
 * @date 2020-04-05
 **/
@Component
@FeignClient(name = "provider-stock-server")
public interface ProviderStockFeign {


    @GetMapping("/inside/stock/deduction")
    int deduction(@RequestParam("name") String name);

}
