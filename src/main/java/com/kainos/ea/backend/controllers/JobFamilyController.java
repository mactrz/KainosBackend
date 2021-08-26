package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.services.JobFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(path = "/job-family")
@Controller
public class JobFamilyController {

    @Autowired
    JobFamilyService jobFamilyService;

    @GetMapping(path = "/")
    public @ResponseBody Iterable<JobFamily> getJobFamiliesByCapabilityName(@RequestParam String capabilityName) {
        return jobFamilyService.getJobFamiliesByCapabilityName(capabilityName);
    }


}
