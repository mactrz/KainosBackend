package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.JobFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
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
        if (!isAlphanumeric(newJobFamilyName) || !isAlphanumeric(jobFamilyName))
            throw new InvalidParameterException("Only alphanumeric characters are allowed in the job family name");
        JobFamily jobFamily = jobFamilyRepository.findById(jobFamilyName).orElseThrow();
        Capability capabilityName = jobFamily.getCapability();
        JobFamily newJobFamily = new JobFamily();
        newJobFamily.setName(newJobFamilyName);
        newJobFamily.setCapability(capabilityName);
        jobFamilyRepository.deleteById(jobFamilyName);
        jobFamilyRepository.save(newJobFamily);
    }

    private boolean isAlphanumeric(String string) {
        return string.matches("[A-Za-z0-9 ]+");
    }

    public void deleteJobFamily(String jobFamilyName) throws EmptyResultDataAccessException {
        jobFamilyRepository.deleteById(jobFamilyName);
    }
}
