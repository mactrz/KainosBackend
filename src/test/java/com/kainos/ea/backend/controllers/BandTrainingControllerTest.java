package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.services.BandTrainingService;
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

    @Test
    public void when_QueryingTrainingByBand_expect_ServiceCalledPassback() {
        List<Training> training = List.of(new Training());
        Mockito.when(bandTrainingService.getTrainingByBand("")).thenReturn(training);
        BandTrainingController bandTrainingController = new BandTrainingController(bandTrainingService);

        List<Training> results = bandTrainingController.getTrainingByBand("");
        Mockito.verify(bandTrainingService).getTrainingByBand("");

        assertEquals(training, results);
    }
}