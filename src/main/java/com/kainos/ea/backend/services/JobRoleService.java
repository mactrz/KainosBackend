package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.repositories.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobRoleService {

    @Autowired
    JobRoleRepository jobRoleRepository;

    // change to list as its simpler
    public List<JobRole> getAllJobRoles(){
        return jobRoleRepository.findAll();
    }

    public List<JobRole> getAllJobRolesSortByBandName(){
        return jobRoleRepository.findAllByOrderByBand();
    }
  
    public List<JobRole> getAllJobRolesSortedByCapability(){
        return jobRoleRepository.findAllByOrderByCapability();
    }

}
