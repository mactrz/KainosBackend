package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.services.JobFamilyService;
import com.kainos.ea.backend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class JobFamilyControllerTest {

    @Mock
    private JobFamilyService jobFamilyService;
    private JobFamilyController jobFamilyController;

    @BeforeEach
    public void setUp() {
        jobFamilyController = new JobFamilyController(jobFamilyService);
    }

    @Test
    public void when_QueryingDataJobs_expect_ServiceCalledPassback() {
        List<JobFamily> jobFamily = List.of(new JobFamily());
        Mockito.when(jobFamilyService.getJobFamiliesByCapabilityName("")).thenReturn(jobFamily);
        JobFamilyController jobFamilyController = new JobFamilyController(jobFamilyService);

        List<JobFamily> results = jobFamilyController.getJobFamiliesByCapabilityName("");

        Mockito.verify(jobFamilyService).getJobFamiliesByCapabilityName("");
        assertEquals(jobFamily, results);
    }

    @Test
    public void when_QueryingUpdateJobFamilyName_expect_ServiceCalledPassback() {
        jobFamilyService.updateJobFamilyName("People Support", "New name");

        Mockito.verify(jobFamilyService).updateJobFamilyName("People Support", "New name");
    }

    @Test
    public void when_QueryingUpdateJobFamilyNameWithNonexistentJobFamily_expect_ServiceThrowsException() throws NoSuchElementException {
        Mockito
                .doThrow(NoSuchElementException.class)
                .when(jobFamilyService).updateJobFamilyName("Unknown", "New name");

        ResponseEntity<Object> result = jobFamilyController.updateJobFamilyName("Unknown", "New name");

        assertEquals(result.getStatusCodeValue(), 400);
    }

    @Test
    public void when_QueryingUpdateJobFamilyName_expect_ServiceReturnsResponseCodeOK() {

        ResponseEntity<Object> result = jobFamilyController.updateJobFamilyName("Unknown", "New name");

        assertEquals(result.getStatusCodeValue(), 200);
    }
}