package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Competency;
import com.kainos.ea.backend.repositories.CompetencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompetencyService {

    @Autowired
    CompetencyRepository competencyRepository;

    public Iterable<Competency> getCompetenciesByBand(String bandName){
        return competencyRepository.getCompetencyByBand(bandName);
    }
}
