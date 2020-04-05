package com.licaibo.consumer.servicer.impl;

import com.licaibo.consumer.feign.ProviderOrderFeign;
import com.licaibo.consumer.feign.ProviderStockFeign;
import com.licaibo.consumer.servicer.OrderStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
@Service
public class OrderStockServiceImpl implements OrderStockService {

    @Autowired
    private ProviderOrderFeign providerOrderFeign;
    @Autowired
    private ProviderStockFeign providerStockFeign;

    /**
     * 下订单和扣除库存
     * @param oderName 订单名称
     * @param stockName 商品名称
     * @return
     */
    @Override
    public int oderStockHandler(String oderName, String stockName) {
        //下订单
        int orderResul = providerOrderFeign.addOrder(oderName);
        //扣除库存
        int stockResul = providerStockFeign.deduction(stockName);

        return orderResul + stockResul;
    }


}
