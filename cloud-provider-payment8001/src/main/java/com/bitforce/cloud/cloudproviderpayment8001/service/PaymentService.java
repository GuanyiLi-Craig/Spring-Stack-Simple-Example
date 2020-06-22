package com.bitforce.cloud.cloudproviderpayment8001.service;

import com.bitforce.cloudcommonapi.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}