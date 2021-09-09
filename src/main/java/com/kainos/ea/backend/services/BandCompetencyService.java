package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.BandCompetency;
import com.kainos.ea.backend.repositories.BandCompetencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BandCompetencyService {

    private BandCompetencyRepository bandCompetencyRepository;

    @Autowired
    public BandCompetencyService(BandCompetencyRepository bandCompetencyRepository) {
        this.bandCompetencyRepository = bandCompetencyRepository;
    }

    public List<BandCompetency> getCompetenciesByBand(String bandName){
        return bandCompetencyRepository.findAllByBandName(bandName);
    }
}
