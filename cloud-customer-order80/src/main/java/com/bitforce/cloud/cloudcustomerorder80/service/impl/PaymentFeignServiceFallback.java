package com.bitforce.cloud.cloudcustomerorder80.service.impl;

import com.bitforce.cloud.cloudcustomerorder80.service.PaymentFeignService;
import com.bitforce.cloudcommonapi.entities.CommonResult;
import com.bitforce.cloudcommonapi.entities.Payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceFallback implements PaymentFeignService {

    @Override
    public CommonResult<Payment> create(Payment payment) {
        return new CommonResult<>(444, "Create Payment failed");
    }

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(444, "Get Payment By Id failed");
    }
    
}