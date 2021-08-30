package com.kainos.ea.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
//@TestPropertySource(locations = "/application-test.properties")
public class BackendApplicationTests {

	@LocalServerPort
	protected static final int PORT = 8080;


	protected static String createURLWithPort(String uri) {
		return "http://localhost:" + PORT + uri;
	}
}
