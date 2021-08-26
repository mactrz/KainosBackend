package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.BandCompetency;
import com.kainos.ea.backend.services.BandCompetencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class BandCompetencyController {

    @Autowired
    BandCompetencyService bandCompetencyService;

    public BandCompetencyController(BandCompetencyService service) {
        this.bandCompetencyService = service;
    }

    @GetMapping("/competency/{bandName}")
    public @ResponseBody
    Iterable<BandCompetency> getCompetenciesByBand(@PathVariable("bandName") String bandName){
        return bandCompetencyService.getCompetenciesByBand(bandName);
    }
}
