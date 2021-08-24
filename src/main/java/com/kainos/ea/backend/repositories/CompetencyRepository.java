package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.Competency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CompetencyRepository extends CrudRepository<Competency, String> {

    @Query( value = "SELECT c.competencyName FROM Competency c INNER JOIN BandCompetency bc Using(competencyName)" +
            " INNER JOIN Band Using(bandName) WHERE bandName = ?1", nativeQuery = true)
    Iterable<Competency> getCompetencyByBand(String bandName);
}
