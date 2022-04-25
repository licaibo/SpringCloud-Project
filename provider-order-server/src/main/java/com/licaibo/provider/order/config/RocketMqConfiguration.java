package com.licaibo.provider.order.config;

import io.netty.channel.DefaultChannelId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置提前加载DefaultChannelId，避免默认2S超时
 * @author licaibo
 * @date 2022-04-22
 **/
@Configuration
public class RocketMqConfiguration {

    @Bean
    public DefaultChannelId newIDefaultChannelId(){
        return DefaultChannelId.newInstance();
    }

}
