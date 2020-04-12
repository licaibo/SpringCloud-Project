package com.licaibo.provider.stock.service.impl;

import com.licaibo.provider.stock.dao.StockDao;
import com.licaibo.provider.stock.entity.Stock;
import com.licaibo.provider.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    /**
     * 扣除库存
     * @return
     */
    @Override
    public int deduction(String name) throws InterruptedException {

        //模拟扣除库存失败
        Thread.sleep(60000);
        String var = null;
        if(var.equals("test")) {
            //do somethins
        }

        Example example = Example.builder(Stock.class).build();
        example.createCriteria().andEqualTo(Stock.FIELD_NAME,name);
        Stock stock = stockDao.selectOneByExample(example);
        if(null != stock && stock.getCount() > 0) {
            stock.setCount(stock.getCount() - 1);
            stock.setUpdateAt(new Date());
            return stockDao.updateByPrimaryKey(stock);
        }

        return 0;
    }


}
