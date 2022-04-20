package com.licaibo.risk.config;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * DingTalk SDK 实例化
 * @author licaibo
 * @date 2022-04-20
 **/
@Slf4j
@Configuration
public class DingTalkClientConfig {

    @Value("${risk.dingtalk.serverUrl}")
    private String serverUrl;

    @Bean
    DingTalkClient dingTalkClientInit() {
        DingTalkClient client = new DefaultDingTalkClient(serverUrl);
        return client;
    }


}
