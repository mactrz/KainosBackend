package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.BandTraining;
import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.repositories.BandTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandTrainingService {

    private BandTrainingRepository bandTrainingRepository;

    @Autowired
    public BandTrainingService(BandTrainingRepository bandTrainingRepository) {
        this.bandTrainingRepository = bandTrainingRepository;
    }

    public List<Training> getTrainingByBandSortedByTrainingType(String bandName) {
        List<BandTraining> bandTrainings = bandTrainingRepository.findByBandNameOrderByTrainingType(bandName);
        return getTrainingFromBandTrainingList(bandTrainings);
    }

    public List<Training> getRecommendedTrainingByBandSortedByTrainingType(String bandName) {
        List<BandTraining> bandTrainings = bandTrainingRepository.findByBandNameAndRecommendedTrueOrderByTrainingType(bandName);
        return getTrainingFromBandTrainingList(bandTrainings);
    }

    public List<Training> getNonRecommendedTrainingByBandSortedByTrainingType(String bandName) {
        List<BandTraining> bandTrainings = bandTrainingRepository.findByBandNameAndRecommendedFalseOrderByTrainingType(bandName);
        return getTrainingFromBandTrainingList(bandTrainings);
    }

    private List<Training> getTrainingFromBandTrainingList(List<BandTraining> bandTrainings) {
        List<Training> trainings = new ArrayList<>();
        for (BandTraining bandTraining : bandTrainings)
            trainings.add(bandTraining.getTraining());
        return trainings;
    }
}
