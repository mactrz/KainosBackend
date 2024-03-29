package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.BandCompetency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BandCompetencyRepository extends CrudRepository<BandCompetency, String> {

    List<BandCompetency> findAllByBandName(String bandName);
}
