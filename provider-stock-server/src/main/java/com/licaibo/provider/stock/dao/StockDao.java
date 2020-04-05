package com.licaibo.provider.stock.dao;

import com.licaibo.provider.stock.entity.Stock;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.dialect.oracle.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
@Repository
public interface StockDao extends Mapper<Stock>, InsertListMapper<Stock> {
}
