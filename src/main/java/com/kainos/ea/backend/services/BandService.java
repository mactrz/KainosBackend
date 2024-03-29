package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandService {

    private BandRepository bandRepository;

    @Autowired
    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    public List<Band> getAllBands() {
        return bandRepository.findAllByOrderByLevelDesc();
    }
    public Optional<Band> getBandByName(String name){ return bandRepository.findById(name); }

    public void deleteBand(String bandName) throws EmptyResultDataAccessException {
        bandRepository.deleteById(bandName);
    }
}
