package com.virtualpairprogrammers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PositionreceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionreceiverApplication.class, args);
	}
}