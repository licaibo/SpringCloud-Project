package com.licaibo.risk.service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author licaibo
 * @date 2022-04-19
 **/
public interface RiskService {


    Map<String, RiskService> router = new HashMap<>();

    @PostConstruct
    default void init() {
        router.put(getType(), this);
    }

    /**
     * 抽象风控类型
     * @return
     */
    String getType();

    /**
     * 发送风控预警消息
     * @return
     */
    boolean sendRiskMessage();


}
