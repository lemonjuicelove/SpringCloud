package com.whut.springcloud.service;

import com.whut.springcloud.bean.CommonResult;
import com.whut.springcloud.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") // value值为注册中心里的服务名称
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") String id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();

}
