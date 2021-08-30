package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.repositories.CapabilityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void when_AddingCapabilities_expect_RepositoryCalledPassback() {
        Capability capability = new Capability();
        Mockito.when(capabilityRepository.save(capability)).thenReturn(capability);

        Capability result = capabilityService.addCapability(capability);
        Mockito.verify(capabilityRepository).save(capability);

        assertEquals(capability, result);
    }
}
