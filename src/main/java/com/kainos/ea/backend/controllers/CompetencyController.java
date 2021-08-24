package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Competency;
import com.kainos.ea.backend.services.CompetencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping(path="/")
public class CompetencyController {

    @Autowired
    CompetencyService competencyService;

    @GetMapping("/competency/{bandName}")
    public @ResponseBody
    Iterable<Competency> getCompetenciesByBand(@PathVariable("bandName") String bandName){
        return competencyService.getCompetenciesByBand(bandName);
    }
}
