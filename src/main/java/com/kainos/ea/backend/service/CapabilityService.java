package com.kainos.ea.backend.service;

import com.kainos.ea.backend.repositories.CapabilityRepository;
import com.kainos.ea.backend.models.Capability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapabilityService {

    @Autowired
    CapabilityRepository capabilityRepository;

    public Iterable<Capability> getCapabilities() {
        return capabilityRepository.findAll();
    }
}
