package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/job-role")
public class JobRoleController {

    @Autowired
    JobRolesService jobRoleService;

    @GetMapping("/list-sorted")
    public @ResponseBody Iterable<JobRole> getAllJobRolesSortedByCapability(){
        return jobRoleService.getAllJobRolesSortedByCapability();
    }
}
