package com.kainos.ea.backend.controllers;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JobRoleControllerTest {

    @LocalServerPort
    private final int port = 8080;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void when_ListSortedEndpointCalled_Expect_Data_To_Contain_Role_With_Id_10() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/job-role/list-sorted"), HttpMethod.GET, entity, String.class);
        String expected = "{\"id\":10,\"name\":\"Tester\",\"specification\":\"Writes tests\"";

        assertTrue(Objects.requireNonNull(response.getBody()).contains(expected));
    }

    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;
    }

}