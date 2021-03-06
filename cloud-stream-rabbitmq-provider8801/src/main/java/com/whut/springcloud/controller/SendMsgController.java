package com.whut.springcloud.controller;

import com.whut.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SendMsgController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        return messageProvider.send();
    }

}
