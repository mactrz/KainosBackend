package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.BandService;
import com.kainos.ea.backend.services.CapabilityService;
import com.kainos.ea.backend.services.JobRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/job-role")
public class JobRoleController {

    private JobRolesService jobRolesService;
    @Autowired
    private BandService bandService;
    @Autowired
    private CapabilityService capabilityService;

    @Autowired
    public JobRoleController(JobRolesService jobRolesService) {
        this.jobRolesService = jobRolesService;
    }

    @GetMapping("/list-sorted")
    public @ResponseBody
    List<JobRole> getAllJobRolesSortedByCapability(){
        return jobRolesService.getAllJobRolesSortedByCapability();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJobRole(@RequestBody JobRole jobRole){
        Optional<Band> band = bandService.getBandByName(jobRole.getBand().getName());
        if(band.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Capability> capability = capabilityService.getCapabilityByName(jobRole.getCapability().getName());
        if(capability.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        jobRole.setCapability(capability.get());
        jobRole.setBand(band.get());
        JobRole savedJobRole = jobRolesService.saveJobRole(jobRole);
        if(savedJobRole == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>("Account created successfully", HttpStatus.CREATED);
        }
    }


}
