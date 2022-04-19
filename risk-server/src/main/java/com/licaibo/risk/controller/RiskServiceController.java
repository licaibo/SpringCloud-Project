package com.licaibo.risk.controller;

import com.licaibo.risk.enums.RiskChannelEnum;
import com.licaibo.risk.service.RiskService;
import org.springframework.web.bind.annotation.*;

/**
 * @author licaibo
 * @date 2022-04-19
 **/
@RestController
@RequestMapping("/risk")
public class RiskServiceController {

    /**
     * 发送钉钉机器人预警消息
     * @return
     */
    @PostMapping("/dingtalk")
    public boolean dingtalk() {
        return RiskService.router.get(RiskChannelEnum.DINGTALK.name()).sendRiskMessage();
    }


}
