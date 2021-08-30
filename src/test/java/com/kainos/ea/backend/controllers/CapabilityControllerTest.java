package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.BackendApplicationTests;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.services.CapabilityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CapabilityControllerTest {

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
