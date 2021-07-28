package com.whut.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class) // 表明这是一个消息的消费者
public class GetMsg {

    @Value("${server.port}")
    private String serverPort;

    // 消息的监听器
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("serverPort为" + serverPort + "接收到的消息：" + message.getPayload());
    }

}
