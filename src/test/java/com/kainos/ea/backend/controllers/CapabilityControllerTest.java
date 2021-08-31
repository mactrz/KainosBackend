package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.services.CapabilityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.InvalidNameException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CapabilityControllerTest {

    @Mock
    private CapabilityService capabilityService;

    private CapabilityController capabilityController;

    @BeforeEach
    public void setUp() {
        capabilityController = new CapabilityController(capabilityService);
    }

    @Test
    public void when_QueryingAllCapabilities_expect_ServiceCalledPassback() {
        List<Capability> capabilities = List.of(new Capability());
        Mockito.when(capabilityService.getCapabilities()).thenReturn(capabilities);

        List<Capability> results = capabilityController.getCapabilities();
        Mockito.verify(capabilityService).getCapabilities();

        assertEquals(capabilities, results);
    }

    @Test
    public void when_AddingCapability_expect_ServiceCalledPassback() throws InvalidNameException, InstanceAlreadyExistsException {
        Capability capability = new Capability();
        Mockito.when(capabilityService.addCapability(capability)).thenReturn(capability);

        Capability result = capabilityController.addCapability(capability);
        Mockito.verify(capabilityService).addCapability(capability);

        assertEquals(capability, result);
    }

    @Test
    public void when_AddingInvalidCapability_expect_NullReturn() throws InvalidNameException, InstanceAlreadyExistsException {
        Capability capability = new Capability("Invalid name!");
        Mockito.when(capabilityService.addCapability(capability)).thenThrow(InvalidNameException.class);

        Capability result = capabilityController.addCapability(capability);
        Mockito.verify(capabilityService).addCapability(capability);

        Assertions.assertNull(result);
    }

    @Test
    public void when_AddingAlreadyExistingCapability_expect_NullReturn() throws InvalidNameException, InstanceAlreadyExistsException {
        Capability capability = new Capability("Existing capability");
        Mockito.when(capabilityService.addCapability(capability)).thenThrow(InstanceAlreadyExistsException.class);

        Capability result = capabilityController.addCapability(capability);
        Mockito.verify(capabilityService).addCapability(capability);

        Assertions.assertNull(result);
    }
}
