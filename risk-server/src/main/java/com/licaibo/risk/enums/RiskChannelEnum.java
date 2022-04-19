package com.licaibo.risk.enums;

/**
 * 风控渠道
 * @author licaibo
 * @date 2022-04-19
 **/
public enum RiskChannelEnum {
    DINGTALK("DINGTALK","钉钉机器人"),
    ;

    String code;
    String desc;

    RiskChannelEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    
    
    
}
