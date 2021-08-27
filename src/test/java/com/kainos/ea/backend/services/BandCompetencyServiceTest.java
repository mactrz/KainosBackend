package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.BandCompetency;
import com.kainos.ea.backend.repositories.BandCompetencyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BandCompetencyTest {

    @Mock
    private BandCompetencyRepository bandCompetencyRepository;

    @Test
    public void when_querying_getCompetenciesByBand_expect_ServiceCalledPassback(){
        Iterable<BandCompetency> bandCompetencies = List.of(new BandCompetency());
        Mockito.when(bandCompetencyRepository.findAllByBand_BandName("string")).thenReturn(bandCompetencies);
        BandCompetencyService bandCompetencyService = new BandCompetencyService(bandCompetencyRepository);

        Iterable<BandCompetency> results = bandCompetencyService.getCompetenciesByBand("string");
        Mockito.verify(bandCompetencyRepository).findAllByBand_BandName("string");

        assertEquals(bandCompetencies, results);
    }
}