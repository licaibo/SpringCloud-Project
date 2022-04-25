package com.licaibo.consumer.rocketMq;

import com.licaibo.common.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * RocketMq 生产者发送例子
 * @author licaibo
 * @date 2022-04-21
 **/
@Slf4j
@Service
public class RocketMqProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    private static final String TOPIC = "MAC-BOOK-CLOUD-TOPIC";


    /**
     * 简单发送
     */
    public void send() {
        UserInfo userInfo = UserInfo.builder().id("rocket-mq-send").username("send").password("send-password").build();
        //rocketMQTemplate.convertAndSend(TOPIC, userInfo);
        rocketMQTemplate.send(TOPIC, MessageBuilder.withPayload(userInfo).build());


    }


    /**
     * 同步
     */
    public void syncSend() {
        UserInfo userInfo = UserInfo.builder().id("rocket-mq-syncSend").username("syncSend").password("syncSend-password").build();
        SendResult sendResult = rocketMQTemplate.syncSend(TOPIC,userInfo);
        log.info("syncSend ... {}",sendResult.toString());
    }

    /**
     * 发送延时消息（上面的发送同步消息，delayLevel的值就为0，因为不延时）
     * 延时消息一共分为18个等级分别为：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
     */
    public void delaySend() {
        UserInfo userInfo = UserInfo.builder().id("rocket-mq-delaySend").username("delaySend").password("delaySend-password").build();
        //等级为3，对应延迟10秒后发送
        rocketMQTemplate.syncSend(TOPIC, MessageBuilder.withPayload(userInfo).build(),3000,5);
    }

    /**
     * 异步
     */
    public void asyncSend() {
        UserInfo userInfo = UserInfo.builder().id("rocket-mq-asyncSend").username("asyncSend").password("asyncSend-password").build();
        rocketMQTemplate.asyncSend(TOPIC,userInfo,new SendCallback(){
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("syncSend success ... {}",sendResult.toString());
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("syncSend exception ...",throwable);
            }
        });

    }

    /**
     * 在 rocketmq-spring-boot-starter 中，Tag 的设置方式： 在 topic后面加上 “:tagName”
     * 源码中是以 “:”进行分割的，前面的是 topic，后面的就是 tag
     */
    public void tagSend() {
        UserInfo userInfo = UserInfo.builder().id("rocket-mq-tagSend").username("tagSend").password("tagSend-password").build();
        rocketMQTemplate.syncSend(TOPIC + ":tagSend", MessageBuilder.withPayload(userInfo).build());
    }








}
