package com.kainos.ea.backend.service;

import com.kainos.ea.backend.models.BandTraining;
import com.kainos.ea.backend.repositories.BandTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandTrainingService {

    @Autowired
    BandTrainingRepository bandTrainingRepository;

    public Iterable<BandTraining> getAllTraining() {
        return bandTrainingRepository.findAll();
    }
}
