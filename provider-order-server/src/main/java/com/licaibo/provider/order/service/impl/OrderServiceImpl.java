package com.licaibo.provider.order.service.impl;

import com.licaibo.provider.order.dao.OrderDao;
import com.licaibo.provider.order.entity.Order;
import com.licaibo.provider.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int add(Order order) {
        return orderDao.insert(order);
    }



}
