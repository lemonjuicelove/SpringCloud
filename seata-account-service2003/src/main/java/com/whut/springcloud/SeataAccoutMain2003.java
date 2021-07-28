package com.whut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeataAccoutMain2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccoutMain2003.class,args);
    }

}
