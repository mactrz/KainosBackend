package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.JobFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JobFamilyService {

    private JobFamilyRepository jobFamilyRepository;

    @Autowired
    public JobFamilyService(JobFamilyRepository jobFamilyRepository) {
        this.jobFamilyRepository = jobFamilyRepository;
    }

    public List<JobFamily> getJobFamiliesByCapabilityName(String capabilityName) {
        return jobFamilyRepository.findByCapabilityName(capabilityName);
    }

    public void updateJobFamilyName(String jobFamilyName, String newJobFamilyName) throws NoSuchElementException {
        JobFamily jobFamily = jobFamilyRepository.findById(jobFamilyName).orElseThrow();
        Capability capabilityName = jobFamily.getCapability();
        JobFamily newJobFamily = new JobFamily();
        newJobFamily.setName(newJobFamilyName);
        newJobFamily.setCapability(capabilityName);
        jobFamilyRepository.deleteById(jobFamilyName);
        jobFamilyRepository.save(newJobFamily);
    }

}
