package com.bitforce.cloud.clouddispatchorder7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DispatchOrder7002 {

	public static void main(String[] args) {
		SpringApplication.run(DispatchOrder7002.class, args);
	}

}
