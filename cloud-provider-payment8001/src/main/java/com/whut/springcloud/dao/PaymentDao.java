package com.whut.springcloud.dao;

import com.whut.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(String id);

}
