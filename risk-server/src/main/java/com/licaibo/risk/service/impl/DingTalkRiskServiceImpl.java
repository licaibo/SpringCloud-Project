package com.licaibo.risk.service.impl;

import com.licaibo.risk.enums.RiskChannelEnum;
import com.licaibo.risk.service.RiskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * dingtalk
 * @author licaibo
 * @date 2022-04-19
 **/
@Slf4j
@Service
public class DingTalkRiskServiceImpl implements RiskService {


    @Override
    public String getType() {
        return RiskChannelEnum.DINGTALK.name();
    }


    @Override
    public boolean sendRiskMessage() {
        //TODO dingtalk
        log.info("dingtalk send ....");
        return false;
    }


}
