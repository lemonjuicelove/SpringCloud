package com.whut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class SeataOrderMain2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2002.class,args);
    }

}
