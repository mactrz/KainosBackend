package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.repositories.JobRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobRolesService {

    @Autowired
    JobRolesRepository jobRolesRepository;

    // change to list as its simpler
    public List<JobRole> getAllJobRoles(){
        return jobRolesRepository.findAll();
    }

    public List<JobRole> getAllJobRolesSortByBandName(){
        return jobRolesRepository.findAllByOrderByBand();
    }
  
    public List<JobRole> getAllJobRolesSortedByCapability(){
        return jobRolesRepository.findAllByOrderByCapability();
    }

}
