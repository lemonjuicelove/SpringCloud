package com.whut.springcloud.service.impl;

import com.whut.springcloud.bean.Payment;
import com.whut.springcloud.dao.PaymentDao;
import com.whut.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(String id) {
        return paymentDao.getPaymentById(id);
    }

}
