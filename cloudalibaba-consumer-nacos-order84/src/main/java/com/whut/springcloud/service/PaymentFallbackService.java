package com.whut.springcloud.service;

import com.whut.springcloud.bean.CommonResult;
import com.whut.springcloud.bean.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444,"服务降级返回");
    }

}
