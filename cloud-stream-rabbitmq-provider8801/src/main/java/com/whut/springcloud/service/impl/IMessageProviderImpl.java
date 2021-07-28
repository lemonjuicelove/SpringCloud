package com.whut.springcloud.service.impl;

import com.whut.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/*
    不需要@Service注解了，定义一个消息的发送管道
 */
@EnableBinding(Source.class) // 表名这是消息的生产者
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String msg = UUID.randomUUID().toString();
        // 发送消息
        output.send(MessageBuilder.withPayload(msg).build());
        System.out.println("msg: " + msg);
        return null;
    }

}
