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
        return jobRolesService.addJobRole(jobRole);
    }
}
