package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.repositories.JobRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JobRolesService {

    @Autowired
    JobRolesRepository jobRolesRepository;
    @Autowired
    BandService bandService;
    @Autowired
    CapabilityService capabilityService;

    public List<JobRole> getAllJobRolesSortedByCapability() {
        return jobRolesRepository.findAllByOrderByCapability();
    }

    public JobRole saveJobRole(JobRole jobRole) {
        return jobRolesRepository.save(jobRole);
    }

    public ResponseEntity<?> addJobRole(JobRole jobRole) {
        Pattern pattern = Pattern.compile("^[A-z][A-z ]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jobRole.getName());
        if (jobRole.getName().length() > 32 || !matcher.find()) {
            return new ResponseEntity<Object>("Invalid role name!", HttpStatus.BAD_REQUEST);
        }
        pattern = Pattern.compile("^[A-z][0-9A-z ().,/-]{0,249}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(jobRole.getName());
        if (jobRole.getSpecification().length() > 250 || !matcher.find()) {
            return new ResponseEntity<Object>("Invalid specification!", HttpStatus.BAD_REQUEST);
        }
        Optional<Band> band = bandService.getBandByName(jobRole.getBand().getName());
        if (band.isEmpty()) {
            return new ResponseEntity<Object>("Band with given name does not exist!", HttpStatus.BAD_REQUEST);
        }
        Optional<Capability> capability = capabilityService.getCapabilityByName(jobRole.getCapability().getName());
        if (capability.isEmpty()) {
            return new ResponseEntity<Object>("Capability with given name does not exist!", HttpStatus.BAD_REQUEST);
        }
        jobRole.setCapability(capability.get());
        jobRole.setBand(band.get());
        JobRole savedJobRole = saveJobRole(jobRole);
        if (savedJobRole == null) {
            return new ResponseEntity<Object>("There was an error while adding a job role! Please, try again later.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>("Account created successfully", HttpStatus.CREATED);
    }
}
