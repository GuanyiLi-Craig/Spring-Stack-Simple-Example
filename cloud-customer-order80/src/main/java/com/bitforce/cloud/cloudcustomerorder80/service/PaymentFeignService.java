package com.bitforce.cloud.cloudcustomerorder80.service;

import com.bitforce.cloud.cloudcustomerorder80.service.impl.PaymentFeignServiceFallback;
import com.bitforce.cloudcommonapi.entities.CommonResult;
import com.bitforce.cloudcommonapi.entities.Payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service", fallback = PaymentFeignServiceFallback.class)
public interface PaymentFeignService {
    @GetMapping(value="/payment/create")
    public CommonResult<Payment> create(Payment payment);

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}