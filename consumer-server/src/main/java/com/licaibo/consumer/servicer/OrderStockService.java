package com.licaibo.consumer.servicer;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
public interface OrderStockService {

    /**
     * 下订单和扣除库存
     * @param oderName 订单名称
     * @param stockName 商品名称
     * @return
     */
    int oderStockHandler(String oderName,String stockName);

}
