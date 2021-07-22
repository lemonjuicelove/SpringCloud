package com.whut.springcloud.dao;

import com.whut.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(String id);

}
