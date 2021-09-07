package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.JobFamily;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobFamilyRepository extends CrudRepository<JobFamily, String> {
    List<JobFamily> findByCapabilityName(String capabilityName);

    List<JobFamily> findByNameAndCapabilityName(String jobFamilyName, String capabilityName);
}
