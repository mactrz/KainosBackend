package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.CapabilityRepository;
import com.kainos.ea.backend.repositories.JobFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.InvalidNameException;
import java.util.List;

@Service
public class JobFamilyService {

    private JobFamilyRepository jobFamilyRepository;
    private CapabilityService capabilityService;

    @Autowired
    public JobFamilyService(JobFamilyRepository jobFamilyRepository, CapabilityService capabilityService) {
        this.jobFamilyRepository = jobFamilyRepository;
        this.capabilityService = capabilityService;
    }

    public List<JobFamily> getJobFamiliesByCapabilityName(String capabilityName) {
        return jobFamilyRepository.findByCapabilityName(capabilityName);
    }

    public JobFamily addJobFamily(JobFamily jobFamily) throws InvalidNameException, InstanceAlreadyExistsException {
        validateJobFamily(jobFamily);
        return jobFamilyRepository.save(jobFamily);
    }

    private void validateJobFamily(JobFamily jobFamily) throws InvalidNameException, InstanceAlreadyExistsException {
        if (!capabilityService.capabilityExists(jobFamily.getCapability().getName()))
            throw new CapabilityDoesNotExistException();
        if (!isAlphanumeric(jobFamily.getName()))
            throw new InvalidNameException("Only alphanumeric characters are allowed in the job family name");
        if (jobFamilyExists(jobFamily.getName(), jobFamily.getCapability().getName()))
            throw new InstanceAlreadyExistsException();
    }

    private boolean isAlphanumeric(String string) {
        return string.matches("[A-Za-z0-9 ]+");
    }

    public boolean jobFamilyExists(String jobFamilyName, String capabilityName) {
        return !jobFamilyRepository.findByNameAndCapabilityName(jobFamilyName, capabilityName).isEmpty();
    }
}
