package com.bitforce.cloud.clouddispatchorder7002.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class DispatchMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("Received message : " + message.getPayload() + " server port " + serverPort);
    }
    
}