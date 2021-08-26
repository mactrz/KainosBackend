package com.kainos.ea.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
public class BackendApplicationTests {

	@LocalServerPort
	protected static final int PORT = 8080;

	@Test
	void contextLoads() {
	}

	protected static String createURLWithPort(String uri) {
		return "http://localhost:" + PORT + uri;
	}
}