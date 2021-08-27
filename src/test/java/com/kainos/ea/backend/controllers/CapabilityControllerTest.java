package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.BackendApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
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

class CapabilityControllerTest extends BackendApplicationTests {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void when_CapabilityEndpointCalled_Expect_DataToContainBrianCox() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/capability/"), HttpMethod.GET, entity, String.class);
        String expected = "{\"name\":\"Data\",\"leadName\":\"Prof Brian Cox\",\"leadPhoto\":\"https://www.thetimes.co.uk/imageserver/image/%2Fmethode%2Ftimes%2Fprod%2Fweb%2Fbin%2Fa176808a-30d8-11eb-8bd6-64d3c9126a9b.jpg\",\"leadMessage\":\"I love space\"}";

        assertTrue(Objects.requireNonNull(response.getBody()).contains(expected));
    }
  
    @Test
    public void getAllCapabilitiesTest() throws Exception{
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/capability/"), HttpMethod.GET, entity, String.class);
        String expected = "\"name\":\"Engineering\"," +
                "\"leadName\":null,\"leadPhoto\":null,\"leadMessage\":null";

        assertTrue(Objects.requireNonNull(response.getBody()).contains(expected));
    }
}
