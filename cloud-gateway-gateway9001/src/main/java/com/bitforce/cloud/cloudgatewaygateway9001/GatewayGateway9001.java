package com.bitforce.cloud.cloudgatewaygateway9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayGateway9001 {

	public static void main(String[] args) {
		SpringApplication.run(GatewayGateway9001.class, args);
	}

}
