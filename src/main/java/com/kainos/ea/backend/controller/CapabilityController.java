package com.kainos.ea.backend.controller;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.service.CapabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/capability")
public class CapabilityController {

    @Autowired
    CapabilityService capabilityService;

    @GetMapping("/")
    public @ResponseBody Iterable<Capability> getCapabilities() {
        return capabilityService.getCapabilities();
    }
}
