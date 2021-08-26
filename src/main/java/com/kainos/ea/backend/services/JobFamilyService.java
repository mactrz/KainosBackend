package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.JobFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobFamilyService {

    @Autowired
    JobFamilyRepository jobFamilyRepository;

    public Iterable<JobFamily> getAllJobFamilies(String capabilityName) {
        return jobFamilyRepository.findByCapabilityCapabilityName(capabilityName);
    }

}
