package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.repositories.BandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BandServiceTest {

    @Mock
    private BandRepository bandRepository;

    @Test
    public void when_QueryingAllBandNames_expect_RepositoryCalledPassback() {
        List<Band> bands = List.of(new Band());
        Mockito.when(bandRepository.findAll()).thenReturn(bands);
        BandService bandService = new BandService(bandRepository);

        List<Band> results = bandService.getAllBands();
        Mockito.verify(bandRepository).findAll();

        assertEquals(bands, results);
    }
}
