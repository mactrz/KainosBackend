package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.controller.CapabilityController;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.services.CapabilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CapabilityControllerTest {

    @Mock
    private CapabilityService capabilityService;

    @Test
    public void when_QueryingAllCapabilities_expect_ServiceCalledPassback() {
        List<Capability> capabilities = List.of(new Capability());
        Mockito.when(capabilityService.getCapabilities()).thenReturn(capabilities);
        CapabilityController capabilityController = new CapabilityController(capabilityService);

        List<Capability> results = capabilityController.getCapabilities();
        Mockito.verify(capabilityService).getCapabilities();

        assertEquals(capabilities, results);
    }
}
