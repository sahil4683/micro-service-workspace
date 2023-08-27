package com.mic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicEurekaApplication.class, args);
	}

}
