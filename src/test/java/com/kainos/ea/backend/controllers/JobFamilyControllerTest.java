package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.services.JobFamilyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class JobFamilyControllerTest {

    @Mock
    private JobFamilyService jobFamilyService;

    @Test
    public void when_QueryingDataJobs_expect_ServiceCalledPassback() {
        List<JobFamily> jobFamily = List.of(new JobFamily());
        Mockito.when(jobFamilyService.getJobFamiliesByCapabilityName("")).thenReturn(jobFamily);
        JobFamilyController jobFamilyController = new JobFamilyController(jobFamilyService);

        List<JobFamily> results = jobFamilyController.getJobFamiliesByCapabilityName("");

        Mockito.verify(jobFamilyService).getJobFamiliesByCapabilityName("");
        assertEquals(jobFamily, results);
    }

    @Test void when_deleteJobFamily_expect_ServiceCalledPassback() {
        JobFamilyController jobFamilyController = new JobFamilyController(jobFamilyService);

        ResponseEntity<Object> expected = new ResponseEntity<>("Job family deleted successfully.", HttpStatus.OK);
        ResponseEntity<Object> result = jobFamilyController.deleteJobFamily("");

        Mockito.verify(jobFamilyService).deleteJobFamily("");
        assertEquals(expected, result);
    }

    @Test void when_deleteJobFamily_expect_ResponseStatusToBe404() {
        JobFamilyController jobFamilyController = new JobFamilyController(jobFamilyService);
        doThrow(EmptyResultDataAccessException.class).when(jobFamilyService).deleteJobFamily("");

        ResponseEntity<Object> expected = new ResponseEntity<>("No such job family exists!", HttpStatus.NOT_FOUND);
        ResponseEntity<Object> result = jobFamilyController.deleteJobFamily("");

        Mockito.verify(jobFamilyService).deleteJobFamily("");
        assertEquals(expected, result);
    }
}