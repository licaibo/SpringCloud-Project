package com.licaibo.consumer.controller;

import com.licaibo.consumer.servicer.OrderStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单和库存
 * @author licaibo
 * @date 2020-04-05
 **/
@Slf4j
@RestController
@RequestMapping("order")
public class OrderStockController {

    @Autowired
    private OrderStockService orderStockService;


    /**
     * 下订单和扣除库存
     * @param oderName 订单名称
     * @param stockName 商品名称
     * @return
     */
    @GetMapping("/handler")
    public int oderStockHandler(@RequestParam String oderName,@RequestParam String stockName) {
        log.info("feign调用");
        return orderStockService.oderStockHandler(oderName, stockName);
    }

}
