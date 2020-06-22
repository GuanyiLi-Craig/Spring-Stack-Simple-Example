package com.bitforce.cloud.cloudproviderpayment8002.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@RestController
@RefreshScope
@Slf4j
public class RuntimeConfigController {
    @Value("${config.info}")
    private String runtimeConfigInfo;

    @RequestMapping(value="payment/runtime")
    public String paymentZk() {
        log.info("Spring could runtime config update " + runtimeConfigInfo);
        return "SpringCloud payment runtime config " + runtimeConfigInfo + '\t' + UUID.randomUUID().toString();
    }
}