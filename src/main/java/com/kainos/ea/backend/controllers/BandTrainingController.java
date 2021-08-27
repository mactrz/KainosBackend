package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.services.BandTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/band-training")
public class BandTrainingController {

    BandTrainingService bandTrainingService;

    @Autowired
    public BandTrainingController(BandTrainingService bandTrainingService) {
        this.bandTrainingService = bandTrainingService;
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Training> getTrainingByBand(@RequestParam String bandName) {
        return bandTrainingService.getTrainingByBand(bandName);
    }
}
