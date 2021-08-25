package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.BandCompetency;
import com.kainos.ea.backend.repositories.BandCompetencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BandCompetencyService {

    @Autowired
    BandCompetencyRepository bandCompetencyRepository;

    public Iterable<BandCompetency> getCompetenciesByBand(String bandName){
        return bandCompetencyRepository.findAllByBand_BandName(bandName);
    }
}
