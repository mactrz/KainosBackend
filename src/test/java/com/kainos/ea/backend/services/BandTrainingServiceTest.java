package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.BandTraining;
import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.repositories.BandTrainingRepository;
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

    @Test
    public void when_QueryingTrainingByBand_expect_RepositoryCalledPassback() {
        Band band = new Band();
        Training training = new Training();
        List<Training> trainings = List.of(training);
        List<BandTraining> bandTrainings = List.of(new BandTraining((short) 0, band, training));
        Mockito.when(bandTrainingRepository.findByBandBandName("")).thenReturn(bandTrainings);
        BandTrainingService bandTrainingService = new BandTrainingService(bandTrainingRepository);

        List<Training> results = bandTrainingService.getTrainingByBand("");
        Mockito.verify(bandTrainingRepository).findByBandBandName("");

        assertEquals(trainings, results);
    }
}
