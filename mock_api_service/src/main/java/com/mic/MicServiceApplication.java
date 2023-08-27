package com.mic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicServiceApplication.class, args);
	}

}
