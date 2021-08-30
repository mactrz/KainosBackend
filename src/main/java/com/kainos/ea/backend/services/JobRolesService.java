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

    public List<JobRole> getAllJobRolesSortedByCapability(){ return jobRolesRepository.findAllByOrderByCapability(); }
    public JobRole saveJobRole(JobRole jobRole){ return jobRolesRepository.save(jobRole); }
}
