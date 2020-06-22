package com.bitforce.cloud.cloudproviderpayment8002.controller;

import java.util.UUID;

import javax.annotation.Resource;
import com.bitforce.cloud.cloudproviderpayment8002.service.PaymentService;
import com.bitforce.cloudcommonapi.entities.CommonResult;
import com.bitforce.cloudcommonapi.entities.Payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("Create Result: " + result);

        if (result > 0) {
            return new CommonResult<Integer>(200, "Create succesfully server " + serverPort, result);
        } else {
            return new CommonResult<>(444, "Create failed server " + serverPort);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("Create Result: " + payment);

        if (payment != null) {
            return new CommonResult<>(200, "Get succesfully server " + serverPort, payment);
        } else {
            return new CommonResult<>(444, "Get failed where id is " + id + " server " + serverPort, null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery() {
        return this.discoveryClient;
    }

    @RequestMapping(value="payment/zk")
    public String paymentZk() {
        return "SpringCloud payment with port " + serverPort + '\t' + UUID.randomUUID().toString();
    }
}