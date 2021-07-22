package com.whut.springcloud.controller;

import com.whut.springcloud.bean.CommonResult;
import com.whut.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") String id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // openfeign-ribbon，客户端默认等待1s
        return paymentFeignService.paymentFeignTimeout();
    }


}
