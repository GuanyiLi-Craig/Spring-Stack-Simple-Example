package com.bitforce.cloud.cloudconfigserver3001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3001 {

	public static void main(String[] args) {
		SpringApplication.run(ConfigCenter3001.class, args);
	}

}
