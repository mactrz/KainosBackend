package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/job-role")
public class JobRoleController {

    @Autowired
    JobRoleService jobRoleService;

    @GetMapping(path = "/band-level")
    public @ResponseBody
    Iterable<JobRole> getAllJobRolesSortedByBandName() {
        return jobRoleService.getAllJobRolesSortByBandName();
    }

}
