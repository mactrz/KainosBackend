package com.kainos.ea.backend.controllers;


import com.kainos.ea.backend.models.BandTraining;
import com.kainos.ea.backend.models.Training;
import com.kainos.ea.backend.service.BandTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class BandTrainingController {

    @Autowired
    BandTrainingService bandTrainingService;

    @GetMapping("/band-training")
    public @ResponseBody Iterable<BandTraining> getAllTraining() {
        return bandTrainingService.getAllTraining();
    }
}
