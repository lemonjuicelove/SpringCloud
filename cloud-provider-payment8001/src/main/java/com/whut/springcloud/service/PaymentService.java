package com.whut.springcloud.service;

import com.whut.springcloud.bean.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(String id);

}
