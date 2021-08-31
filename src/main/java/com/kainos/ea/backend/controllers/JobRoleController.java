package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/list-sorted")
    public @ResponseBody
    List<JobRole> getAllJobRolesSortedByCapability(){
        return jobRoleService.getAllJobRolesSortedByCapability();
    }


}
