package com.mic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicGetwayApplicationTests {

	@Value(value = "${server.port}")
	private String appPort;
	
	@Value(value = "${spring.application.name}")
	private String appName;
	
	@Test
	void verifyPort() {
	Assertions.assertEquals(appPort, "8081");
	}
	
	@Test
	void verifyAppName() {
	Assertions.assertEquals(appName, "mock_api_eureka");
	}

}