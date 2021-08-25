package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.BandCompetency;
import org.springframework.data.repository.CrudRepository;

public interface BandCompetencyRepository extends CrudRepository<BandCompetency, String> {

    public Iterable<BandCompetency> findAllByBand_BandName(String bandName);
}
