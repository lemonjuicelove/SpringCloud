package com.whut.springcloud.controller;

import com.whut.springcloud.bean.CommonResult;
import com.whut.springcloud.bean.Payment;
import com.whut.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果:" + result);
        if (result > 0){
            return new CommonResult(200,"插入成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(404,"插入失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") String id){
        Payment result = paymentService.getPaymentById(id);
        log.info("插入结果:" + result);
        if (result != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(404,"查询失败",null);
        }
    }

    @GetMapping("/payment/lb/{id}")
    public String paymentLb(@PathVariable("id") Integer id){
        return "paymentLb，ID：" + id + ",serverPort: " + serverPort;
    }

}
