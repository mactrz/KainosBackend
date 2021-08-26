package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.JobRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface JobRolesRepository extends CrudRepository<JobRole, String> {

    List<JobRole> findAllByOrderByCapability();

}
