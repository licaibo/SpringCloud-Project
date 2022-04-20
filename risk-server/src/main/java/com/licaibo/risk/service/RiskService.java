package com.licaibo.risk.service;
import com.taobao.api.ApiException;

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
     * 发送文本消息
     * @return
     */
    boolean sendRiskTextMessage(String content) throws ApiException;

    /**
     * 发送Markdown消息
     * @return
     */
    boolean sendRiskMarkdownMessage(String title,String content) throws ApiException;


}
