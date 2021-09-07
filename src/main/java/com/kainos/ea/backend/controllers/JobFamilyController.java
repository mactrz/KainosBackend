package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.services.JobFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path = "")
    @ResponseBody
    public ResponseEntity<Object> deleteJobFamily(@RequestParam String jobFamilyName) {
        try {
            jobFamilyService.deleteJobFamily(jobFamilyName);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("No such job family exists!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job family deleted successfully.", HttpStatus.OK);
    }
}
