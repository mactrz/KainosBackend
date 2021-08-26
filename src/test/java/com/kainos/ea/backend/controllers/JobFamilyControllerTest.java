package com.kainos.ea.backend.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class JobFamilyControllerTest {

    @LocalServerPort
    private final int port = 8080;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void when_QueryingDataJobs_expect_DataJobs() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/job-family/?capabilityName=Data"),
                HttpMethod.GET,
                entity, String.class);
        String expected = "[{\"jobFamilyName\":\"Analysis & Data Architecture\"," +
                "\"capability\":{\"capabilityName\":\"Data\",\"leadName\":\"Prof Brian Cox\",\"leadPhoto\":\"https://www.thetimes.co.uk/imageserver/image/%2Fmethode%2Ftimes%2Fprod%2Fweb%2Fbin%2Fa176808a-30d8-11eb-8bd6-64d3c9126a9b.jpg\",\"leadMessage\":\"I love space\"}},{\"jobFamilyName\":\"Data Engineering\",\"capability\":{\"capabilityName\":\"Data\",\"leadName\":\"Prof Brian Cox\",\"leadPhoto\":\"https://www.thetimes.co.uk/imageserver/image/%2Fmethode%2Ftimes%2Fprod%2Fweb%2Fbin%2Fa176808a-30d8-11eb-8bd6-64d3c9126a9b.jpg\",\"leadMessage\":\"I love space\"}},{\"jobFamilyName\":\"Data Strategy and Planning\",\"capability\":{\"capabilityName\":\"Data\",\"leadName\":\"Prof Brian Cox\",\"leadPhoto\":\"https://www.thetimes.co.uk/imageserver/image/%2Fmethode%2Ftimes%2Fprod%2Fweb%2Fbin%2Fa176808a-30d8-11eb-8bd6-64d3c9126a9b.jpg\",\"leadMessage\":\"I love space\"}}]";
        assertTrue(Objects.requireNonNull(response.getBody()).contains(expected));
    }

    @Test
    public void when_QueryingInvalidCapabilityName_expect_EmptyList() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/job-family/?capabilityName" +
                        "=fakecapability"),
                HttpMethod.GET,
                entity, String.class);
        assertEquals("[]", response.getBody());
    }

    @Test public void when_InvalidEndpointCalled_expect_404() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/job-family/invalidendpoint"),
                HttpMethod.GET,
                entity, String.class);
        assertTrue(Objects.requireNonNull(response.getBody()).contains("404"));
    }

    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;
    }
}