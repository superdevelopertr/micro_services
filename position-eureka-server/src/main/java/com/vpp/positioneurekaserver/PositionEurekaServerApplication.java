package com.vpp.positioneurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PositionEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionEurekaServerApplication.class, args);
	}

}
