package com.bitforce.cloud.cloudproviderpayment8001.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import com.bitforce.cloud.cloudproviderpayment8001.service.MessageProviderService;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(Source.class)
@Slf4j
public class MessageProviderServiceImpl implements MessageProviderService {

    @Resource
    private MessageChannel output;

    @Override
    public String send(Long id) {
        String messageString = "payment id" + id + " " + UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(messageString).build());
        log.info("send payment id " + id);
        return null;
    }
    
}