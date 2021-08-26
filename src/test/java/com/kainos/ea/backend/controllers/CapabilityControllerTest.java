package com.kainos.ea.backend.controllers;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CapabilityControllerTest {

    @LocalServerPort
    private final int port = 8080;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void getAllCapabilitiesTest() throws Exception{
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/capability/"), HttpMethod.GET, entity, String.class);
        String expected = "{\"capabilityName\":\"Engineering\"," +
                "\"leadName\":null,\"leadPhoto\":null,\"leadMessage\":null}";

        assertTrue(Objects.requireNonNull(response.getBody()).contains(expected));
    }

    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;
    }

}