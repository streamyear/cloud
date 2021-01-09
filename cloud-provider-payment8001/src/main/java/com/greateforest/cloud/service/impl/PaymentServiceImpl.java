package com.greateforest.cloud.service.impl;

import com.greateforest.cloud.dao.PaymentDao;
import com.greateforest.cloud.entities.Payment;
import com.greateforest.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById( Long id){
        return paymentDao.getPaymentById(id);

    }
}
