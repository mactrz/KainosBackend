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
class BandCompetencyServiceTest {

    @Mock
    private BandCompetencyRepository bandCompetencyRepository;

    @Test
    public void when_QueryingGetCompetenciesByBand_expect_ServiceCalledPassback(){
        List<BandCompetency> bandCompetencies = List.of(new BandCompetency());
        Mockito.when(bandCompetencyRepository.findAllByBandName("string")).thenReturn(bandCompetencies);
        BandCompetencyService bandCompetencyService = new BandCompetencyService(bandCompetencyRepository);

        Iterable<BandCompetency> results = bandCompetencyService.getCompetenciesByBand("string");
        Mockito.verify(bandCompetencyRepository).findAllByBandName("string");

        assertEquals(bandCompetencies, results);
    }
}