package com.greateforest.controller;

import com.greateforest.cloud.entities.CommonResult;
import com.greateforest.cloud.entities.Payment;
import com.greateforest.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        return paymentFeignService.create(payment);
    }
}
