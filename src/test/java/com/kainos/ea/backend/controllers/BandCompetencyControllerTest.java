package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.services.BandCompetencyService;
import com.kainos.ea.backend.services.BandCompetencyService.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BandCompetencyControllerTest {


    @LocalServerPort
    private final int port = 8080;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void getCompetenciesByBandHappyPathId() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/competency/Associate"), HttpMethod.GET, entity, String.class);
        String expected = "\"id\":9";

        System.out.println(response.getBody());
        JSONAssert.assertEquals(expected, response.getBody().substring(2,8), false);
    }

    @Test
    public void getCompetenciesByBandNoBandNotFound() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/competency/"), HttpMethod.GET, entity, String.class);
        int expected = 404;

        System.out.println(response.getBody());
        assertEquals(expected, response.getStatusCodeValue());
    }

    @Test
    public void getCompetenciesByBandBadBandNameEmptyList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/competency/asdasd"), HttpMethod.GET, entity, String.class);
        String expected = "[]";

        System.out.println(response.getBody());
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void getCompetenciesByBandBadBandHappyPathNotNull() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/competency/Associate"), HttpMethod.GET, entity, String.class);
        String expected = "[]";

        System.out.println(response.getBody());
        assertFalse(response.getBody().isBlank());
    }

    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;
    }
}