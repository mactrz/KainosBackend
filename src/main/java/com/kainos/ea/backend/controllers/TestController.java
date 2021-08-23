package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Test;
import com.kainos.ea.backend.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class TestController {

    @Autowired
    TestRepository testRepository;

    @GetMapping("/test")
    public @ResponseBody Iterable<Test> getAllTestsMessages(){
        return testRepository.findAll();
    }
}
