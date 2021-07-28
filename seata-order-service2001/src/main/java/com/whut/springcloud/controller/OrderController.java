package com.whut.springcloud.controller;

import com.whut.springcloud.domain.CommonResult;
import com.whut.springcloud.domain.Order;
import com.whut.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    // 分布式的事务注解
    @GlobalTransactional
    public CommonResult create(){
        BigDecimal money = new BigDecimal(100);
        Order order = new Order(null,1L,1L,10,money,1);
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
