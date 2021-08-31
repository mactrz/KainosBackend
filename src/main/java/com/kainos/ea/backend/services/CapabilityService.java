package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.repositories.CapabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.InvalidNameException;
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

    public Capability addCapability(Capability capability) throws InvalidNameException, InstanceAlreadyExistsException {
        if (!capability.getName().matches("[A-Za-z0-9 ]+")) {
            throw new InvalidNameException("Only alphanumeric characters are allowed in the capability name");
        }
        for (Capability existingCapability : getCapabilities()) {
            if (existingCapability.getName().equals(capability.getName())) {
                throw new InstanceAlreadyExistsException();
            }
        }
        return capabilityRepository.save(capability);
    }
}
