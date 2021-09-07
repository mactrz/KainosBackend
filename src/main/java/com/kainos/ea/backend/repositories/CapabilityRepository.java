package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.Capability;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CapabilityRepository extends CrudRepository<Capability, String> {
    List<Capability> findAll();
    List<Capability> findByName(String name);
}
