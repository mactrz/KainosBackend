package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.repositories.JobRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRoleService {

    @Autowired
    JobRolesRepository jobRolesRepository;

    public Iterable<JobRole> getAllJobRoles(){
        return jobRolesRepository.findAll();
    }
}
