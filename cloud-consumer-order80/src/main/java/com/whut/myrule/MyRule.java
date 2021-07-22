package com.whut.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 负载均衡规则的配置文件类，用于修改负载均衡的规则
public class MyRule {

    @Bean
    public IRule mySelfRule(){
        // 定义为随机规则
        return new RandomRule();
    }

}
