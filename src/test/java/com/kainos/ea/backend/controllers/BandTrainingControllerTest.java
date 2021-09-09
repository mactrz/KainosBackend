package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.services.BandTrainingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BandTrainingControllerTest {

    @Mock
    private BandTrainingService bandTrainingService;

    private BandTrainingController bandTrainingController;

    private List<Training> training;

    @BeforeEach
    public void setUp() {
        bandTrainingController = new BandTrainingController(bandTrainingService);
        training = List.of(new Training());
    }

    @Test
    public void when_QueryingRecommendedTrainingByBand_expect_ServiceCalledPassback() {
        Mockito.when(bandTrainingService.getRecommendedTrainingByBandSortedByTrainingType("")).thenReturn(training);

        List<Training> results = bandTrainingController.getTrainingByBandSortedByTrainingType("", true);
        Mockito.verify(bandTrainingService).getRecommendedTrainingByBandSortedByTrainingType("");

        assertEquals(training, results);
    }

    @Test
    public void when_QueryingNonRecommendedTrainingByBand_expect_ServiceCalledPassback() {
        Mockito.when(bandTrainingService.getNonRecommendedTrainingByBandSortedByTrainingType("")).thenReturn(training);

        List<Training> results = bandTrainingController.getTrainingByBandSortedByTrainingType("", false);
        Mockito.verify(bandTrainingService).getNonRecommendedTrainingByBandSortedByTrainingType("");

        assertEquals(training, results);
    }
}