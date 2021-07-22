package com.whut.springcloud;

import com.whut.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient // 代表该工程为Eureka的客户端
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class) // 更改ribbon负载均衡的规则,name为要访问的服务名称，configuration为自定义的规则
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }

}
