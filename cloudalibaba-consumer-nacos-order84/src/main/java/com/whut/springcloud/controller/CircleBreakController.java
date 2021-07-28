package com.whut.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.whut.springcloud.bean.CommonResult;
import com.whut.springcloud.bean.Payment;
import com.whut.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private PaymentService paymentService;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback") // 没有配置
    // @SentinelResource(value = "fallback",fallback = "handlerFallback") // fallback只负责处理业务异常
    // @SentinelResource(value = "fallback",blockHandler = "blockHandler") // Handlerback只负责sentinel控制台的配置违规
    // 都进行配置，如果都满足了，进入blockHandler的处理逻辑，因为会先发生限流降级
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id,Throwable e) {
        return new CommonResult<>(444,"兜底异常handlerFallback: " + e.getMessage());
    }

    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        return new CommonResult<>(444,"兜底异常blockHandler: " + e.getMessage());
    }

    @GetMapping("/consumer/paymentSQL/{id}")
    // 如果服务提供者宕机，走的是PaymentFallbackService的逻辑处理，如果没有PaymentFallbackService，那么走的是handlerFallback的逻辑处理
    // @SentinelResource(value = "paymentFallback",fallback = "handlerFallback")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
