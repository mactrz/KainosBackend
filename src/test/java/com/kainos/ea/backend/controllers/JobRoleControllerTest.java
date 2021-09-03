package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JobRoleControllerTest {

    @Mock
    private JobRoleService jobRoleService;

    @Test
    public void when_QueryingAllJobRolesSortedByBandName_expect_ServiceCalledPassback(){
        List<JobRole> jobRoles = List.of(new JobRole());
        Mockito.when(jobRoleService.getAllJobRolesSortByBandName()).thenReturn(jobRoles);
        JobRoleController jobRoleController = new JobRoleController(jobRoleService);

        List<JobRole> results = jobRoleController.getAllJobRolesSortedByBandName();
        // check if the service has been called
        Mockito.verify(jobRoleService).getAllJobRolesSortByBandName();

        assertEquals(jobRoles, results);
    }

    @Test
    public void when_QueryingAllJobRolesSortedByCapability_expect_ServiceCalledPassback(){
        List<JobRole> jobRoles = List.of(new JobRole());
        Mockito.when(jobRoleService.getAllJobRolesSortedByCapability()).thenReturn(jobRoles);

        JobRoleController jobRoleController = new JobRoleController(jobRoleService);

        List<JobRole> results = jobRoleController.getAllJobRolesSortedByCapability();
        // check if the service has been called
        Mockito.verify(jobRoleService).getAllJobRolesSortedByCapability();

        assertEquals(jobRoles, results);
    }
    @Test
    public void when_AddingNewJobRoleWithCorrectData_expect_ResponseStatusToBe201() throws IllegalArgumentException {
        ResponseEntity<Object> expectedResponse = new ResponseEntity<>(HttpStatus.CREATED);
        JobRole jobRole = new JobRole();
        JobRoleController jobRoleController = new JobRoleController(jobRoleService);
        ResponseEntity<Object> result = jobRoleController.addJobRole(jobRole);
        Mockito.verify(jobRoleService).addJobRole(jobRole);

        assertEquals(expectedResponse.getStatusCode(), result.getStatusCode());
    }
    @Test
    public void when_AddingNewJobRoleWithInvalidData_expect_ResponseStatusToBe400() throws IllegalArgumentException {
        ResponseEntity<Object> expectedResponse = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        JobRole jobRole = new JobRole();
        Mockito.doThrow(IllegalArgumentException.class).when(jobRoleService).addJobRole(jobRole);
        JobRoleController jobRoleController = new JobRoleController(jobRoleService);
        ResponseEntity<Object> result = jobRoleController.addJobRole(jobRole);
        Mockito.verify(jobRoleService).addJobRole(jobRole);

        assertEquals(expectedResponse.getStatusCode(), result.getStatusCode());
    }
}