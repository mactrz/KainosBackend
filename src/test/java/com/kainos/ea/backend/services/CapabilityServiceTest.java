package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.repositories.CapabilityRepository;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CapabilityServiceTest {

    @Mock
    private CapabilityRepository capabilityRepository;

    private CapabilityService capabilityService;

    @BeforeEach
    public void setUp() {
        capabilityService = new CapabilityService(capabilityRepository);
    }

    @Test
    public void when_QueryingAllCapabilities_expect_RepositoryCalledPassback() {
        List<Capability> capabilities = List.of(new Capability());
        Mockito.when(capabilityRepository.findAll()).thenReturn(capabilities);

        List<Capability> results = capabilityService.getCapabilities();
        Mockito.verify(capabilityRepository).findAll();

        assertEquals(capabilities, results);
    }

    @Test
    public void when_AddingValidCapability_expect_RepositoryCalledPassback() throws InvalidNameException, InstanceAlreadyExistsException {
        Capability capability = new Capability("Valid Name");
        Mockito.when(capabilityRepository.save(capability)).thenReturn(capability);

        Capability result = capabilityService.addCapability(capability);
        Mockito.verify(capabilityRepository).save(capability);

        assertEquals(capability, result);
    }

    @Test
    public void when_AddingInvalidCapability_expect_InvalidNameExceptionThrown() {
        Capability capability = new Capability("<Invalid Name>!");

        assertThrows(InvalidNameException.class, () -> capabilityService.addCapability(capability));
    }

    @Test
    public void when_AddingBlankCapability_expect_InvalidNameExceptionThrown() {
        Capability capability = new Capability("");

        assertThrows(InvalidNameException.class, () -> capabilityService.addCapability(capability));
    }

    @Test
    public void when_AddingExistingCapability_expect_InstanceAlreadyExistsExceptionThrown() {
        String capabilityName = "Existing capability";
        Capability existingCapability = new Capability(capabilityName);
        existingCapability.setLeadName("Joe Bloggs");
        Capability newCapability = new Capability(capabilityName);
        List<Capability> capabilities = List.of(existingCapability);
        Mockito.when(capabilityRepository.findByName(capabilityName)).thenReturn(capabilities);

        assertThrows(InstanceAlreadyExistsException.class, () -> capabilityService.addCapability(newCapability));
    }

    @Test
    public void when_CheckingExistingCapability_expect_CapabilityExistsReturnsTrue() {
        String capabilityName = "Existing Capability";
        Capability existingCapability = new Capability(capabilityName);
        List<Capability> capabilities = List.of(existingCapability);
        Mockito.when(capabilityRepository.findByName(capabilityName)).thenReturn(capabilities);

        boolean result = capabilityService.capabilityExists(capabilityName);
        Mockito.verify(capabilityRepository).findByName(capabilityName);

        Assertions.assertTrue(result);
    }

    @Test
    public void when_CheckingNewCapability_expect_CapabilityExistsReturnsFalse() {
        String capabilityName = "New Capability";
        List<Capability> capabilities = List.of();
        Mockito.when(capabilityRepository.findByName(capabilityName)).thenReturn(capabilities);

        boolean result = capabilityService.capabilityExists(capabilityName);
        Mockito.verify(capabilityRepository).findByName(capabilityName);

        Assertions.assertFalse(result);
    }
}
