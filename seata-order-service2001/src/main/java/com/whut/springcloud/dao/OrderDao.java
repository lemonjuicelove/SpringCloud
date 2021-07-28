package com.whut.springcloud.dao;

import com.whut.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    // 新建订单
    void create(Order order);

    // 修改订单状态
    void update(Long userId);

}
