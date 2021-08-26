
package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.BackendApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BandTrainingControllerTest extends BackendApplicationTests {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void when_BandTrainingEndpointCalledWithApprentice_Expect_DataToContainExampleTraining() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/band-training?bandName=Apprentice"),
                HttpMethod.GET, entity, String.class);
        String expected = "{\"trainingName\":\"Example Training\",\"trainingType\":\"PROFESSIONAL_SKILLS\",\"sharepointURL\":\"https://www.google.com/\"}";

        assertTrue(Objects.requireNonNull(response.getBody()).contains(expected));
    }

    @Test
    public void when_BandTrainingEndpointCalledWithBadBand_Expect_EmptyJSON() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/band-training?bandName=xyz"),
                HttpMethod.GET, entity, String.class);
        String expected = "[]";

        assertTrue(Objects.requireNonNull(response.getBody()).contains(expected));
    }

    @Test
    public void when_BandTrainingEndpointCalledWithNoParameter_Expect_ClientError() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/band-training"),
                HttpMethod.GET, entity, String.class);

        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    public void when_BandTrainingEndpointCalledWithBadParameter_Expect_ClientError() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/band-training?abc=xyz"),
                HttpMethod.GET, entity, String.class);

        assertTrue(response.getStatusCode().is4xxClientError());
    }
}