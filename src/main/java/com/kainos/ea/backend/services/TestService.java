package com.kainos.ea.backend.services;


import com.kainos.ea.backend.models.Test;
import com.kainos.ea.backend.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    public Iterable<Test> getAllTestMessages(){
        return testRepository.findAll();
    }
}
