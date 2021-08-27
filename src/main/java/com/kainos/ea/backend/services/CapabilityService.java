package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.repositories.CapabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapabilityService {

    @Autowired
    CapabilityRepository capabilityRepository;

    public List<Capability> getAllCapabilities(){
        return capabilityRepository.findAll();
    }
}
