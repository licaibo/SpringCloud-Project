package com.licaibo.provider.order.rocketMq;

import com.licaibo.common.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author licaibo
 * @date 2022-04-21
 **/
@Slf4j
@Service
@RocketMQMessageListener(topic = "MAC-BOOK-CLOUD-TOPIC", consumerGroup = "${rocketmq.consumer.group}")
public class RocketMqConsumer implements RocketMQListener<UserInfo> {
    @Override
    public void onMessage(UserInfo userInfo) {
        log.info("rocketmq consumer ... {} , {}",System.currentTimeMillis(),userInfo);
    }
}
