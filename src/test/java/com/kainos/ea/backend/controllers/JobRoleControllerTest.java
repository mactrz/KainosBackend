package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.JobRolesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JobRoleControllerTest {

    @Mock
    private JobRolesService jobRolesService;

    @Test
    public void when_QueryingAllJobRolesSortedByBandName_expect_ServiceCalledPassback(){
        List<JobRole> jobRoles = List.of(new JobRole());
        Mockito.when(jobRolesService.getAllJobRolesSortByBandName()).thenReturn(jobRoles);
        JobRoleController jobRoleController = new JobRoleController(jobRolesService);

        List<JobRole> results = jobRoleController.getAllJobRolesSortedByBandName();
        // check if the service has been called
        Mockito.verify(jobRolesService).getAllJobRolesSortByBandName();

        assertEquals(jobRoles, results);
    }

    @Test
    public void when_QueryingAllJobRolesSortedByCapability_expect_ServiceCalledPassback(){
        List<JobRole> jobRoles = List.of(new JobRole());
        Mockito.when(jobRolesService.getAllJobRolesSortedByCapability()).thenReturn(jobRoles);

        JobRoleController jobRoleController = new JobRoleController(jobRolesService);

        List<JobRole> results = jobRoleController.getAllJobRolesSortedByCapability();
        // check if the service has been called
        Mockito.verify(jobRolesService).getAllJobRolesSortedByCapability();

        assertEquals(jobRoles, results);
    }
}