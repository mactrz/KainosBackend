package com.kainos.ea.backend.controllers;


import com.kainos.ea.backend.models.BandCompetency;
import com.kainos.ea.backend.services.BandCompetencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class JobRoleControllerTest {

    @Mock
    private BandCompetencyService bandCompetencyService;

    @Test
    public void when_querying_getCompetenciesByBand_expect_ServiceCalledPassback(){
        List<BandCompetency> bandCompetencies = List.of(new BandCompetency());
        Mockito.when(bandCompetencyService.getCompetenciesByBand("string")).thenReturn(bandCompetencies);
        BandCompetencyController bandCompetencyController = new BandCompetencyController(bandCompetencyService);

        Iterable<BandCompetency> results = bandCompetencyController.getCompetenciesByBand("string");
        Mockito.verify(bandCompetencyService).getCompetenciesByBand("string");

        assertEquals(bandCompetencies, results);
    }
}
