package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.JobFamily;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface JobFamilyRepository extends CrudRepository<JobFamily, String> {
    Iterable<JobFamily> findByCapabilityCapabilityName(String capabilityName);
}
