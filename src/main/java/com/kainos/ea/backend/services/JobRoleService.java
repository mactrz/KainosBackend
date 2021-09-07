package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.repositories.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JobRoleService {


    JobRoleRepository jobRoleRepository;
    BandService bandService;
    CapabilityService capabilityService;

    @Autowired
    public JobRoleService(JobRoleRepository jobRoleRepository, BandService bandService, CapabilityService capabilityService) {
        this.jobRoleRepository = jobRoleRepository;
        this.bandService = bandService;
        this.capabilityService = capabilityService;
    }

    // change to list as its simpler
    public List<JobRole> getAllJobRoles(){
        return jobRoleRepository.findAllByOrderByCapability();
    }

    public List<JobRole> getAllJobRolesSortByBandName(){
        return jobRoleRepository.findAllByOrderByBand();
    }
  
    public List<JobRole> getAllJobRolesSortedByCapability(){
        return jobRoleRepository.findAllByOrderByCapability();
    }

    public JobRole saveJobRole(JobRole jobRole) {
        return jobRoleRepository.save(jobRole);
    }

    public void addJobRole(JobRole jobRole) throws IllegalArgumentException {
        if (jobRole.getName().length() > 32 || violatesRegex(jobRole.getName(), "^[A-z][A-z ]+$")) {
            throw new IllegalArgumentException("Invalid role name!");
        }
        if (jobRole.getSpecification().length() > 250 || violatesRegex(jobRole.getSpecification(), "^[A-z][0-9A-z '().,/-]{0,249}$")) {
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

    public void deleteJobRole(int id) {
        jobRoleRepository.deleteById(id);
    }

    private boolean violatesRegex(String textToBeValidated, String regex){
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(textToBeValidated);
        return !matcher.find();
    }
}
