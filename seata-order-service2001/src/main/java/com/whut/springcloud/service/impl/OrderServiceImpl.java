package com.whut.springcloud.service.impl;

import com.whut.springcloud.dao.OrderDao;
import com.whut.springcloud.domain.Order;
import com.whut.springcloud.service.AccountService;
import com.whut.springcloud.service.OrderService;
import com.whut.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {

        log.info("开始创建订单");
        orderDao.create(order);

        log.info("开始调用库存微服务");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("开始调用账户微服务");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("开始修改订单状态");
        orderDao.update(order.getUserId());

    }

}
