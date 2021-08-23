package com.kainos.ea.Backend.controler;

import com.kainos.ea.Backend.model.JobRole;
import com.kainos.ea.Backend.service.JobRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class JobRoleController {

    @Autowired
    private JobRoleService jobRoleService;


//    SAMPLE POST REQUEST
//    @PostMapping("/sample-path-post")
//    public ResponseEntity<Void> createStudent() {
//        //jobRoleService.method();
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//        return ResponseEntity.created(location).build();
//    }

//   SAMPLE GET REQUEST
//    @GetMapping("/sample-path-get")
//    public JobRole retrieveJobRole(@PathVariable Integer jobRole_id) {
//        return jobRoleService.retriveJobRole(jobRole_id);
//    }
}
