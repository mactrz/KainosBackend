package com.kainos.ea.backend.controllers;


import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.services.CapabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/capability")
public class CapabilityController {

    private CapabilityService capabilityService;

    @Autowired
    public CapabilityController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @GetMapping(path = "/")
    public @ResponseBody
    List<Capability> getAllCapabilities() {
        return capabilityService.getAllCapabilities();
    }
}
