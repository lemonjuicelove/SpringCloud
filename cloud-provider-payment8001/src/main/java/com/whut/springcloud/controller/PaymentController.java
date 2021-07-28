package com.whut.springcloud.controller;

import com.whut.springcloud.bean.CommonResult;
import com.whut.springcloud.bean.Payment;
import com.whut.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    // 用于服务发现，得到微服务的相关信息
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        // eureka注册过的微服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service: "+service);
        }

        // 一个微服务下面的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/lb/{id}")
    public String paymentLb(@PathVariable("id") Integer id){
        return "paymentLb，ID：" + id + ",serverPort: " + serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi,zipkin";
    }

}
