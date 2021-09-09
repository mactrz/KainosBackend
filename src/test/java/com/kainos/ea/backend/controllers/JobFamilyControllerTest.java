package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.services.JobFamilyService;
import com.kainos.ea.backend.services.UserService;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.CapabilityDoesNotExistException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.InvalidNameException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

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
        Mockito.doThrow(NoSuchElementException.class)
                .when(jobFamilyService).updateJobFamilyName("Unknown", "New name");

        ResponseEntity<Object> result = jobFamilyController.updateJobFamilyName("Unknown", "New name");

        assertEquals(result.getStatusCodeValue(), 400);
    }

    @Test
    public void when_QueryingUpdateJobFamilyName_expect_ServiceReturnsResponseCodeOK() {
        ResponseEntity<Object> result = jobFamilyController.updateJobFamilyName("Unknown", "New name");

        assertEquals(result.getStatusCodeValue(), 200);
    }
    
    public void when_AddingJobFamily_expect_ServiceCalledPassback() throws InvalidNameException, InstanceAlreadyExistsException {
        JobFamily jobFamily = new JobFamily();
        Mockito.when(jobFamilyService.addJobFamily(jobFamily)).thenReturn(jobFamily);

        JobFamily result = jobFamilyController.addJobFamily(jobFamily);
        Mockito.verify(jobFamilyService).addJobFamily(jobFamily);

        assertEquals(jobFamily, result);
    }

    @Test
    public void when_AddingJobFamilyToNonExistentCapability_expect_ServiceCalledPassbackAndNullReturn() throws InvalidNameException, InstanceAlreadyExistsException {
        JobFamily jobFamily = new JobFamily();
        Mockito.when(jobFamilyService.addJobFamily(jobFamily)).thenThrow(CapabilityDoesNotExistException.class);

        JobFamily result = jobFamilyController.addJobFamily(jobFamily);
        Mockito.verify(jobFamilyService).addJobFamily(jobFamily);

        Assertions.assertNull(result);
    }

    @Test
    public void when_AddingInvalidJobFamily_expect_ServiceCalledPassbackAndNullReturn() throws InvalidNameException, InstanceAlreadyExistsException {
        JobFamily jobFamily = new JobFamily();
        Mockito.when(jobFamilyService.addJobFamily(jobFamily)).thenThrow(InvalidNameException.class);

        JobFamily result = jobFamilyController.addJobFamily(jobFamily);
        Mockito.verify(jobFamilyService).addJobFamily(jobFamily);

        Assertions.assertNull(result);
    }

    @Test
    public void when_AddingExistingJobFamily_expect_ServiceCalledPassbackAndNullReturn() throws InvalidNameException, InstanceAlreadyExistsException {
        JobFamily jobFamily = new JobFamily();
        Mockito.when(jobFamilyService.addJobFamily(jobFamily)).thenThrow(InstanceAlreadyExistsException.class);

        JobFamily result = jobFamilyController.addJobFamily(jobFamily);
        Mockito.verify(jobFamilyService).addJobFamily(jobFamily);

        Assertions.assertNull(result);
    }

    @Test
    public void when_CheckingExistingJobFamily_expect_ServiceCalledPassback() {
        String jobFamilyName = "Existing job family";
        String capabilityName = "Existing capability";
        Mockito.when(jobFamilyService.jobFamilyExists(jobFamilyName, capabilityName)).thenReturn(true);

        boolean result = jobFamilyController.jobFamilyExists(jobFamilyName, capabilityName);
        Mockito.verify(jobFamilyService).jobFamilyExists(jobFamilyName, capabilityName);

        assertTrue(result);
    }

    @Test
    public void when_CheckingNonExistingJobFamily_expect_ServiceCalledPassback() {
        String jobFamilyName = "New job family";
        String capabilityName = "New capability";
        Mockito.when(jobFamilyService.jobFamilyExists(jobFamilyName, capabilityName)).thenReturn(false);

        boolean result = jobFamilyController.jobFamilyExists(jobFamilyName, capabilityName);
        Mockito.verify(jobFamilyService).jobFamilyExists(jobFamilyName, capabilityName);

        assertFalse(result);

    }
  
    @Test void when_DeletingJobFamily_expect_ServiceCalledPassback() {
        JobFamilyController jobFamilyController = new JobFamilyController(jobFamilyService);

        ResponseEntity<Object> expected = new ResponseEntity<>("Job family deleted successfully.", HttpStatus.OK);
        ResponseEntity<Object> result = jobFamilyController.deleteJobFamily("");

        Mockito.verify(jobFamilyService).deleteJobFamily("");
        assertEquals(expected, result);
    }

    @Test void when_DeletingJobFamily_expect_ResponseStatusToBe404() {
        JobFamilyController jobFamilyController = new JobFamilyController(jobFamilyService);
        doThrow(EmptyResultDataAccessException.class).when(jobFamilyService).deleteJobFamily("");

        ResponseEntity<Object> expected = new ResponseEntity<>("No such job family exists!", HttpStatus.NOT_FOUND);
        ResponseEntity<Object> result = jobFamilyController.deleteJobFamily("");

        Mockito.verify(jobFamilyService).deleteJobFamily("");
        assertEquals(expected, result);
    }
}
