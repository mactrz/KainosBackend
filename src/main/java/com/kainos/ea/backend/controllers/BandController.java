package com.kainos.ea.backend.controllers;


import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/band")
public class BandController {

    @Autowired
    BandService bandService;

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Band> getAllBands(){
        return bandService.getAllBands();
    }
}
