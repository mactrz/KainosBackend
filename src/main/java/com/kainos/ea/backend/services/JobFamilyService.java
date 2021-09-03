package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.JobFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobFamilyService {

    private JobFamilyRepository jobFamilyRepository;

    @Autowired
    public JobFamilyService(JobFamilyRepository jobFamilyRepository) {
        this.jobFamilyRepository = jobFamilyRepository;
    }

    public List<JobFamily> getJobFamiliesByCapabilityName(String capabilityName) {
        return jobFamilyRepository.findByCapabilityName(capabilityName);
    }

    public ResponseEntity<String> deleteJobFamily(String jobFamilyName) {
        try {
            jobFamilyRepository.deleteById(jobFamilyName);
            return new ResponseEntity<>(jobFamilyName, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(jobFamilyName, HttpStatus.NOT_FOUND);
        }
    }
}
