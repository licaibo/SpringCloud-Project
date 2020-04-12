package com.licaibo.provider.stock.inside;

import com.licaibo.provider.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 库存
 * @author licaibo
 * @date 2020-04-05
 **/
@RestController
@RequestMapping("/inside/stock")
public class StockFeginController {

    @Autowired
    private StockService stockService;

    /**
     * 扣除库存
     * @param name
     * @return
     */
    @GetMapping("/deduction")
    public int deduction(@RequestParam("name") String name) throws InterruptedException {
        return stockService.deduction(name);
    }

}
