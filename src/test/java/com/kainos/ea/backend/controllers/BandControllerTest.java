package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.services.BandService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BandControllerTest {

    @Mock
    private BandService bandService;

    @Test
    public void when_QueryingAllBandNames_expect_ServiceCalledPassback() {
        Iterable<Band> bands = List.of(new Band());
        Mockito.when(bandService.getAllBands()).thenReturn(bands);
        BandController bandController = new BandController(bandService);

        Iterable<Band> results = bandController.getAllBands();
        Mockito.verify(bandService).getAllBands();

        assertEquals(bands, results);
    }
}
