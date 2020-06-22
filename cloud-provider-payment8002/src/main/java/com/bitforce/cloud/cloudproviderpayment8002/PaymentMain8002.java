package com.bitforce.cloud.cloudproviderpayment8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PaymentMain8002 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8002.class, args);
	}

}
