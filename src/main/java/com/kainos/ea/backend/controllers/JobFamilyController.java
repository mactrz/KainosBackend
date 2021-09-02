package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.services.CapabilityDoesNotExistException;
import com.kainos.ea.backend.services.JobFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.InvalidNameException;
import java.util.List;

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

    @PostMapping("")
    public JobFamily addJobFamily(@RequestBody JobFamily jobFamily) {
        try {
            return jobFamilyService.addJobFamily(jobFamily);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/exists")
    public @ResponseBody
    boolean jobFamilyExists(@RequestParam String jobFamilyName, @RequestParam String capabilityName) {
        return jobFamilyService.jobFamilyExists(jobFamilyName, capabilityName);
    }
}
