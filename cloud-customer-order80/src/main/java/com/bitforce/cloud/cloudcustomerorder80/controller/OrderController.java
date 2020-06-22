package com.bitforce.cloud.cloudcustomerorder80.controller;

import java.util.UUID;

import javax.annotation.Resource;

import com.bitforce.cloud.cloudcustomerorder80.service.PaymentFeignService;
import com.bitforce.cloudcommonapi.entities.CommonResult;
import com.bitforce.cloudcommonapi.entities.Payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value="/customer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("Costomer create payment "+payment);
        return paymentFeignService.create(payment);
    }

    @GetMapping(value="/customer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("Costomer get payment by id " + id);
        return paymentFeignService.getPaymentById(id);
    }

    @RequestMapping(value="/order/zk")
    public String paymentZk() {
        return "SpringCloud order with port " + serverPort + '\t' + UUID.randomUUID().toString();
    }
}