package com.licaibo.provider.order.dao;

import com.licaibo.provider.order.entity.Order;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.dialect.oracle.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
@Repository
public interface OrderDao extends Mapper<Order>, InsertListMapper<Order> {
}
