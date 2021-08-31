package com.kainos.ea.backend.controllers;


import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.services.CapabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.InvalidNameException;
import java.util.List;

@Controller
@RequestMapping(path = "/capability")
public class CapabilityController {

    private CapabilityService capabilityService;

    @Autowired
    public CapabilityController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @GetMapping("/")
    public @ResponseBody
    List<Capability> getCapabilities() {
        return capabilityService.getCapabilities();
    }

    @PostMapping("/")
    public Capability addCapability(@RequestBody Capability capability) {
        try {
            return capabilityService.addCapability(capability);
        } catch (InvalidNameException e) {
            return null;
        }
    }
}
