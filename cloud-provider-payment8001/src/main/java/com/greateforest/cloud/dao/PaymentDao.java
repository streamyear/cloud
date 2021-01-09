package com.greateforest.cloud.dao;

import com.greateforest.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int create(Payment payment); //写

    public Payment getPaymentById(@Param("id") Long id);  //读取
}
