package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.repositories.JobRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JobRolesService {

    private JobRolesRepository jobRolesRepository;
    private BandService bandService;
    private CapabilityService capabilityService;

    @Autowired
    public JobRolesService(JobRolesRepository jobRolesRepository, BandService bandService, CapabilityService capabilityService) {
        this.jobRolesRepository = jobRolesRepository;
        this.bandService = bandService;
        this.capabilityService = capabilityService;
    }

    public List<JobRole> getAllJobRolesSortedByCapability() {
        return jobRolesRepository.findAllByOrderByCapability();
    }

    public JobRole saveJobRole(JobRole jobRole) {
        return jobRolesRepository.save(jobRole);
    }

    public void addJobRole(JobRole jobRole) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^[A-z][A-z ]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jobRole.getName());
        if (jobRole.getName().length() > 32 || !matcher.find()) {
            throw new IllegalArgumentException("Invalid role name!");
        }
        pattern = Pattern.compile("^[A-z][0-9A-z '().,/-]{0,249}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(jobRole.getSpecification());
        if (jobRole.getSpecification().length() > 250 || !matcher.find()) {
            throw new IllegalArgumentException("Invalid specification!");
        }
        Optional<Band> band = bandService.getBandByName(jobRole.getBand().getName());
        if (band.isEmpty()) {
            throw new IllegalArgumentException("Band with given name does not exist!");
        }
        Optional<Capability> capability = capabilityService.getCapabilityByName(jobRole.getCapability().getName());
        if (capability.isEmpty()) {
            throw new IllegalArgumentException("Capability with given name does not exist!");
        }
        jobRole.setCapability(capability.get());
        jobRole.setBand(band.get());
        JobRole savedJobRole = saveJobRole(jobRole);
        if (savedJobRole == null) {
            throw new IllegalArgumentException("There was an error while adding a job role! Please, try again later.");
        }
    }
}
