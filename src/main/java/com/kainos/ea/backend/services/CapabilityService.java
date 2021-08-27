package com.kainos.ea.backend.services;

import com.kainos.ea.backend.repositories.CapabilityRepository;
import com.kainos.ea.backend.models.Capability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapabilityService {

    private CapabilityRepository capabilityRepository;

    @Autowired
    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> getCapabilities() {
        return capabilityRepository.findAll();
    }
}
