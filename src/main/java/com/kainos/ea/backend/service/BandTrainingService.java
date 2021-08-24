package com.kainos.ea.backend.service;

import com.kainos.ea.backend.models.BandTraining;
import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.repositories.BandTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import static java.util.stream.StreamSupport.stream;

@Service
public class BandTrainingService {

    @Autowired
    BandTrainingRepository bandTrainingRepository;

    public Iterable<Training> getTrainingByBand(String bandName) {
        Iterable<BandTraining> bandTrainings = bandTrainingRepository.findByBandBandName(bandName);
        Iterator<Training> trainingIterator = stream(bandTrainings.spliterator(), true)
                .map(BandTraining::getTraining)
                .iterator();
        return () -> trainingIterator;
    }
}
