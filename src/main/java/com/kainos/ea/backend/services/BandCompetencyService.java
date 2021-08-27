package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.BandCompetency;
import com.kainos.ea.backend.repositories.BandCompetencyRepository;
import org.springframework.stereotype.Service;


@Service
public class BandCompetencyService {

    private BandCompetencyRepository bandCompetencyRepository;

    public BandCompetencyService(BandCompetencyRepository bandCompetencyRepository) {
        this.bandCompetencyRepository = bandCompetencyRepository;
    }

    public Iterable<BandCompetency> getCompetenciesByBand(String bandName){
        return bandCompetencyRepository.findAllByBand_BandName(bandName);
    }
}
