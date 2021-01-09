package com.greateforest.cloud.service;

import com.greateforest.cloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment); //写

    public Payment getPaymentById(Long id);  //读取
}
