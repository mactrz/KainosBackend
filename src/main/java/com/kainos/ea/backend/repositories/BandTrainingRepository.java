package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.BandTraining;
import org.springframework.data.repository.CrudRepository;

public interface BandTrainingRepository extends CrudRepository<BandTraining, Short> {

    Iterable<BandTraining> findAll();
}
