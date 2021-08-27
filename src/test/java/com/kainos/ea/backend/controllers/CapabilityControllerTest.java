package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.BackendApplicationTests;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.CapabilityService;
import com.kainos.ea.backend.services.JobRolesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CapabilityControllerTest extends BackendApplicationTests {

    @Mock
    private CapabilityService capabilityService;

    @Test
    public void when_QueryingAllCapabilities_expect_ServiceCalledPassback(){
        List<Capability> capabilities = List.of(new Capability());
        Mockito.when(capabilityService.getAllCapabilities()).thenReturn(capabilities);
        CapabilityController capabilityController = new CapabilityController(capabilityService);

        List<Capability> results = capabilityController.getAllCapabilities();
        // check if the service has been called
        Mockito.verify(capabilityService).getAllCapabilities();

        assertEquals(capabilities, results);
    }
}
