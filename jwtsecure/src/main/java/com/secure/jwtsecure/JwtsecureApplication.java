package com.secure.jwtsecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JwtsecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtsecureApplication.class, args);
	}

}
