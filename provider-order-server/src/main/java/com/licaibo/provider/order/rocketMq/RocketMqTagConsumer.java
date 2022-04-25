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
@RocketMQMessageListener(topic = "MAC-BOOK-CLOUD-TOPIC", selectorExpression = "tagSend", consumerGroup = "parallels-vm-mac-consumer-group-tag")
public class RocketMqTagConsumer implements RocketMQListener<UserInfo> {

    @Override
    public void onMessage(UserInfo userInfo) {
        log.info("rocketmq tag consumer ... {} , {}",System.currentTimeMillis(),userInfo);
//        String str = null;
//        if(str.length() == 1) {
//            log.info("string length is one ...");
//        }

        log.info("rocketmq tag consumer over... {} , {}",System.currentTimeMillis(),userInfo);

    }
}
