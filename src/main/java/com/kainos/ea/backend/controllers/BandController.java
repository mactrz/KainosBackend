package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/band")
public class BandController {

    private BandService bandService;

    @Autowired
    public BandController(BandService bandService) { this.bandService = bandService; }

    @GetMapping("/")
    public @ResponseBody
    List<Band> getAllBands() {
        return bandService.getAllBands();
    }

    @DeleteMapping(path = "")
    @ResponseBody
    public ResponseEntity<Object> deleteBand(@RequestParam String bandName) {
        try {
            bandService.deleteBand(bandName);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("No such band exists!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Band deleted successfully.", HttpStatus.OK);
    }
}
