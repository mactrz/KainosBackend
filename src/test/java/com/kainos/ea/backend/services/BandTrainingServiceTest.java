package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.BandTraining;
import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.repositories.BandTrainingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BandTrainingServiceTest {

    @Mock
    private BandTrainingRepository bandTrainingRepository;

    private BandTrainingService bandTrainingService;

    private List<Training> trainings;
    private List<BandTraining> bandTrainings;

    @BeforeEach
    public void setUp() {
        bandTrainingService = new BandTrainingService(bandTrainingRepository);
        Band band = new Band();
        Training training = new Training();
        trainings = List.of(training);
        bandTrainings = List.of(new BandTraining((short) 0, band, training, true));
    }

    @Test
    public void when_QueryingTrainingByBand_expect_RepositoryCalledPassback() {
        Mockito.when(bandTrainingRepository.findByBandNameOrderByTrainingType("")).thenReturn(bandTrainings);

        List<Training> results = bandTrainingService.getTrainingByBandSortedByTrainingType("");
        Mockito.verify(bandTrainingRepository).findByBandNameOrderByTrainingType("");

        assertEquals(trainings, results);
    }

    @Test
    public void when_QueryingRecommendedTrainingByBand_expect_RepositoryCalledPassback() {
        Mockito.when(bandTrainingRepository.findByBandNameAndRecommendedTrueOrderByTrainingType("")).thenReturn(bandTrainings);

        List<Training> results = bandTrainingService.getRecommendedTrainingByBandSortedByTrainingType("");
        Mockito.verify(bandTrainingRepository).findByBandNameAndRecommendedTrueOrderByTrainingType("");

        assertEquals(trainings, results);
    }

    @Test
    public void when_QueryingNonRecommendedTrainingByBand_expect_RepositoryCalledPassback() {
        Mockito.when(bandTrainingRepository.findByBandNameAndRecommendedFalseOrderByTrainingType("")).thenReturn(bandTrainings);

        List<Training> results = bandTrainingService.getNonRecommendedTrainingByBandSortedByTrainingType("");
        Mockito.verify(bandTrainingRepository).findByBandNameAndRecommendedFalseOrderByTrainingType("");

        assertEquals(trainings, results);
    }
}
