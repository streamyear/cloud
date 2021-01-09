package com.greateforest.cloud.controller;

import com.greateforest.cloud.entities.CommonResult;
import com.greateforest.cloud.entities.Payment;
import com.greateforest.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+payment);
        if (result>0){
            //成功
            return new CommonResult(200,"插入数据库成功",result);
        }
        return new CommonResult(500,"插入数据库失败",null);
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        if (payment!=null){  //说明有数据，能查询成功
            return new CommonResult(200,"查询成功",payment);
        }
        return new CommonResult(444,"没有对应记录，查询ID："+id,null);
    }
}
