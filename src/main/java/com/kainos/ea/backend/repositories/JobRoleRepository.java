package com.kainos.ea.backend.repositories;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.kainos.ea.backend.models.JobRole;
import org.springframework.data.repository.CrudRepository;

public interface JobRoleRepository extends CrudRepository<JobRole, Integer> {

    List<JobRole> findAllByOrderByCapability();
}
