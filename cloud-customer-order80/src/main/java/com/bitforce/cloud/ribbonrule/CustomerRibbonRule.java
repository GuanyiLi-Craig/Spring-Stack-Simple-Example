package com.bitforce.cloud.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRibbonRule {
    
    @Bean
    public IRule customerRule() {
        return new RandomRule();
    }
}