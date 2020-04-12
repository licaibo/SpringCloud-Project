package com.licaibo.provider.stock.service;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
public interface StockService {

    /**
     * 扣除库存
     * @return
     */
    int deduction(String name) throws InterruptedException;

}
