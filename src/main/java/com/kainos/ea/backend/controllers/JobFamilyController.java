package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.services.JobFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping(path = "/job-family")
@Controller
public class JobFamilyController {

    private JobFamilyService jobFamilyService;

    @Autowired
    public JobFamilyController(JobFamilyService jobFamilyService) {
        this.jobFamilyService = jobFamilyService;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<JobFamily> getJobFamiliesByCapabilityName(@RequestParam String capabilityName) {
        return jobFamilyService.getJobFamiliesByCapabilityName(capabilityName);
    }

    @PatchMapping(path = "/{jobFamilyName}/{jobFamilyNewName}")
    public @ResponseBody
    ResponseEntity<Object> updateJobFamilyName(@PathVariable("jobFamilyName") String jobFamilyName, @PathVariable("jobFamilyNewName") String jobFamilyNewName) {
        try{
            jobFamilyService.updateJobFamilyName(jobFamilyName, jobFamilyNewName);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Job Family edited successfully!", HttpStatus.OK);
    }


}
