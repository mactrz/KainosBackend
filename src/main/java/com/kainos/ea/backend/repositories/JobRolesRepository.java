package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.JobRole;
import org.springframework.data.repository.CrudRepository;

public interface JobRolesRepository extends CrudRepository<JobRole, Integer> {

    Iterable<JobRole> findAllByOrderByBand();

}
