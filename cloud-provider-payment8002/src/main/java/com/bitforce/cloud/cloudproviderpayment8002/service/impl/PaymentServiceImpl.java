package com.bitforce.cloud.cloudproviderpayment8002.service.impl;

import javax.annotation.Resource;
import com.bitforce.cloud.cloudproviderpayment8002.dao.PaymentDao;
import com.bitforce.cloud.cloudproviderpayment8002.service.PaymentService;
import com.bitforce.cloudcommonapi.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPaymentByIdHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="1500"),
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public Payment getPaymentById(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        return paymentDao.getPaymentById(id);
    }

    public Payment getPaymentByIdHandler(Long id) {
        log.info("Payment Service Busy or Error");
        return new Payment(-1L, "ERROR_CODE");
    }
}