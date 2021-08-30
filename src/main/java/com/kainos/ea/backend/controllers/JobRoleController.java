package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRolesService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
