package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.BackendApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BandControllerTest extends BackendApplicationTests {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void when_BandsEndpointCalled_Expect_DataToContainAllBands() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/bands"),
                HttpMethod.GET, entity, String.class);
        String expected = "[{\"bandName\":\"Apprentice\"},{\"bandName\":\"Associate\"},{\"bandName\":\"Consultant\"},{\"bandName\":\"Senior Associate\"},{\"bandName\":\"Trainee\"}]";

        assertEquals(Objects.requireNonNull(response.getBody()), expected);
    }
}
