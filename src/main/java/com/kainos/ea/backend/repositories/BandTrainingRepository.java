package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.BandTraining;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BandTrainingRepository extends CrudRepository<BandTraining, Short> {

    List<BandTraining> findByBandName(String bandName);
}
