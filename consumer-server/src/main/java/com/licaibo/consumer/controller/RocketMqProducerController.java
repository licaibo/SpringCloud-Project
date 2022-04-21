package com.licaibo.consumer.controller;

import com.licaibo.consumer.rocketMq.RocketMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licaibo
 * @date 2022-04-21
 **/
@RestController
@RequestMapping("/rocket/producer")
public class RocketMqProducerController {

    @Autowired
    private RocketMqProducer rocketMqProducer;


    @GetMapping("/send")
    public void send() {
        rocketMqProducer.send();
    }

    @GetMapping("/syncSend")
    public void syncSend() {
        rocketMqProducer.syncSend();
    }

    @GetMapping("/delaySend")
    public void delaySend() {
        rocketMqProducer.delaySend();
    }

    @GetMapping("/asyncSend")
    public void asyncSend() {
        rocketMqProducer.asyncSend();
    }

    @GetMapping("/tagSend")
    public void tagSend() {
        rocketMqProducer.tagSend();
    }



}
