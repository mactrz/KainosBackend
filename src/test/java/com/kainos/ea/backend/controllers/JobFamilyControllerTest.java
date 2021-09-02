package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.services.CapabilityDoesNotExistException;
import com.kainos.ea.backend.services.JobFamilyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.InvalidNameException;
import java.util.List;
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

        List<JobFamily> results = jobFamilyController.getJobFamiliesByCapabilityName("");

        Mockito.verify(jobFamilyService).getJobFamiliesByCapabilityName("");
        assertEquals(jobFamily, results);
    }

    @Test
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
}