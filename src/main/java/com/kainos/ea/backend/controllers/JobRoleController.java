package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/job-roles")
public class JobRoleController {

    @Autowired
    JobRoleService jobRoleService;

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<JobRole> getAllJobRoles(){
        return jobRoleService.getAllJobRoles();
    }


}
