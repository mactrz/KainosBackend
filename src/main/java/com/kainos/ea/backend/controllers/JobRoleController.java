package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/job-role")
public class JobRoleController {

    private JobRolesService jobRolesService;

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
    public ResponseEntity<Object> addJobRole(@RequestBody JobRole jobRole){
        try{
            jobRolesService.addJobRole(jobRole);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Job role created successfully!", HttpStatus.CREATED);
    }
}
