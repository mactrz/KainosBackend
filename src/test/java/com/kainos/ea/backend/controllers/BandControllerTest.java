package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.services.BandService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class BandControllerTest {

    @Mock
    private BandService bandService;

    @Test
    public void when_QueryingAllBandNames_expect_ServiceCalledPassback() {
        List<Band> bands = List.of(new Band());
        Mockito.when(bandService.getAllBands()).thenReturn(bands);
        BandController bandController = new BandController(bandService);

        List<Band> results = bandController.getAllBands();
        Mockito.verify(bandService).getAllBands();

        assertEquals(bands, results);
    }

    @Test void when_deleteBand_expect_ServiceCalledPassback() {
        BandController bandController = new BandController(bandService);

        ResponseEntity<Object> expected = new ResponseEntity<>("Band deleted successfully.", HttpStatus.OK);
        ResponseEntity<Object> result = bandController.deleteBand("");

        Mockito.verify(bandService).deleteBand("");
        assertEquals(expected, result);
    }

    @Test void when_deleteJobFamily_expect_ResponseStatusToBe404() {
        BandController bandController = new BandController(bandService);
        doThrow(EmptyResultDataAccessException.class).when(bandService).deleteBand("");

        ResponseEntity<Object> expected = new ResponseEntity<>("No such band exists!", HttpStatus.NOT_FOUND);
        ResponseEntity<Object> result = bandController.deleteBand("");

        Mockito.verify(bandService).deleteBand("");
        assertEquals(expected, result);
    }
}
