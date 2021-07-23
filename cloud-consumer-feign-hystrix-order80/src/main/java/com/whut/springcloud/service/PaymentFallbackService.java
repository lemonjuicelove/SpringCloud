package com.whut.springcloud.service;

import org.springframework.stereotype.Component;

// 该类作用是统一为接口里的方法进行异常处理
// 主要用于处理服务端宕机的情况
@Component
public class PaymentFallbackService implements PaymentFeignHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "PaymentFallbackService fall paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall paymentInfo_TimeOut";
    }

}
