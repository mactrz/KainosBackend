package com.kainos.ea.backend.controllers;


import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.services.CapabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/capability")
public class CapabilityController {

    @Autowired
    CapabilityService capabilityService;

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Capability> getAllCapabilities() {
        return capabilityService.getAllCapabilities();
    }
}
