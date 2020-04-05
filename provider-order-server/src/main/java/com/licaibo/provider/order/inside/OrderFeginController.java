package com.licaibo.provider.order.inside;

import com.licaibo.provider.order.entity.Order;
import com.licaibo.provider.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * 订单
 * @author licaibo
 * @date 2020-04-05
 **/
@RestController
@RequestMapping("/inside/order")
public class OrderFeginController {

    @Autowired
    private OrderService orderService;

    /**
     * 下订单
     * @param name
     * @return
     */
    @GetMapping("/add")
    public int add(@RequestParam("name") String name) {
        Order order = Order.builder().orderId("123456").name(name).creatAt(new Date()).build();
        return orderService.add(order);
    }


}
