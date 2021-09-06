package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/job-role")
public class JobRoleController {

    private JobRoleService jobRoleService;

    @Autowired
    public JobRoleController(JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @GetMapping(path = "/band-level")
    public @ResponseBody
    List<JobRole> getAllJobRolesSortedByBandName() {
        return jobRoleService.getAllJobRolesSortByBandName();
    }

    @GetMapping(path = "/list-sorted")
    public @ResponseBody
    List<JobRole> getAllJobRolesSortedByCapability(){
        return jobRoleService.getAllJobRolesSortedByCapability();
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<Object> addJobRole(@RequestBody JobRole jobRole){
        try{
            jobRoleService.addJobRole(jobRole);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Job role created successfully!", HttpStatus.CREATED);
    }

    @DeleteMapping(path = "")
    public void deleteJobRole(@RequestBody JobRole jobRole) {
        jobRoleService.deleteJobRole(jobRole);
    }
}
