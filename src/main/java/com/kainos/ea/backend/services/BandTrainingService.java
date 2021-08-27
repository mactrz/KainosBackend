package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.BandTraining;
import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.repositories.BandTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.StreamSupport.stream;

@Service
public class BandTrainingService {

    BandTrainingRepository bandTrainingRepository;

    @Autowired
    public BandTrainingService(BandTrainingRepository bandTrainingRepository) {
        this.bandTrainingRepository = bandTrainingRepository;
    }

    public Iterable<Training> getTrainingByBand(String bandName) {
        Iterable<BandTraining> bandTrainings = bandTrainingRepository.findByBandBandName(bandName);
        List<Training> trainings = new ArrayList<>();
        for (BandTraining bandTraining : bandTrainings) {
            trainings.add(bandTraining.getTraining());
        }
        return trainings;
    }
}
