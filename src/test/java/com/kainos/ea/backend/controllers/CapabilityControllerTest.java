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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.InvalidNameException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;

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
    public void when_AddingInvalidCapability_expect_ServiceCalledPassbackAndNullReturn() throws InvalidNameException, InstanceAlreadyExistsException {
        Capability capability = new Capability("Invalid name!");
        Mockito.when(capabilityService.addCapability(capability)).thenThrow(InvalidNameException.class);

        Capability result = capabilityController.addCapability(capability);
        Mockito.verify(capabilityService).addCapability(capability);

        Assertions.assertNull(result);
    }

    @Test
    public void when_AddingExistingCapability_expect_ServiceCalledPassbackAndNullReturn() throws InvalidNameException, InstanceAlreadyExistsException {
        Capability capability = new Capability("Existing capability");
        Mockito.when(capabilityService.addCapability(capability)).thenThrow(InstanceAlreadyExistsException.class);

        Capability result = capabilityController.addCapability(capability);
        Mockito.verify(capabilityService).addCapability(capability);

        Assertions.assertNull(result);
    }

    @Test
    public void when_CheckingExistingCapability_expect_ServiceCalledPassback() {
        String capabilityName = "Existing capability";
        Mockito.when(capabilityService.capabilityExists(capabilityName)).thenReturn(true);

        boolean result = capabilityController.capabilityExists(capabilityName);
        Mockito.verify(capabilityService).capabilityExists(capabilityName);

        assertTrue(result);
    }

    @Test
    public void when_deleteCapability_expect_ServiceCalledPassback() {
        CapabilityController capabilityController = new CapabilityController(capabilityService);

        ResponseEntity<Object> expected = new ResponseEntity<>("Capability successfully deleted.", HttpStatus.OK);
        ResponseEntity<Object> result = capabilityController.deleteCapability("");

        Mockito.verify(capabilityService).deleteCapability("");
        assertEquals(expected, result);
    }

    @Test
    public void when_deleteInvalidCapability_expect_ResponseStatusToBe404() {
        CapabilityController capabilityController = new CapabilityController(capabilityService);
        doThrow(EmptyResultDataAccessException.class).when(capabilityService).deleteCapability("");

        ResponseEntity<Object> expected = new ResponseEntity<>("No such capability exists!", HttpStatus.NOT_FOUND);
        ResponseEntity<Object> result = capabilityController.deleteCapability("");

        Mockito.verify(capabilityService).deleteCapability("");
        assertEquals(expected, result);
    }
}
