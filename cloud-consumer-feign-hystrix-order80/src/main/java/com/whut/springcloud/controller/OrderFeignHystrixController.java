package com.whut.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.whut.springcloud.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_Fallback")
public class OrderFeignHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id){
        return paymentFeignHystrixService.paymentInfo_Ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
    })*/
    @HystrixCommand // 主要用于处理运行时异常和超时异常，当和宕机异常处理一起使用时，宕机异常处理的方法优先度高
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        // int age = 10 / 0;
        return paymentFeignHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "对方系统繁忙或自己运行出错";
    }

    // 全局fallback方法
    public String payment_Global_Fallback(){
        return "全局异常处理信息，请稍后再试";
    }


}
