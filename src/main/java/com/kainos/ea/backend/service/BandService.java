package com.kainos.ea.backend.service;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandService {

    @Autowired
    BandRepository bandRepository;

    public Iterable<Band> getBands() {
        return bandRepository.findAll();
    }
}
