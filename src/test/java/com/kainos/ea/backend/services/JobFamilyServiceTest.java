package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.CapabilityRepository;
import com.kainos.ea.backend.repositories.JobFamilyRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.InvalidNameException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class JobFamilyServiceTest {

    @Mock
    private JobFamilyRepository jobFamilyRepository;
    @Mock
    private CapabilityService capabilityService;
  
    private JobFamilyService jobFamilyService;
    private JobFamily jobFamily;

    @BeforeEach
    void setUp() {
        jobFamilyService = new JobFamilyService(jobFamilyRepository, capabilityService);
        jobFamily = new JobFamily();
        jobFamily.setName("Name");
    }

     @Test
    void when_GettingJobFamiliesByCapabilityName_expect_RepositoryCalledPassback() {
        List<JobFamily> jobFamily = List.of(new JobFamily());
        Mockito.when(jobFamilyRepository.findByCapabilityName("")).thenReturn(jobFamily);
        JobFamilyService jobFamilyService = new JobFamilyService(jobFamilyRepository, capabilityService);

        List<JobFamily> results = jobFamilyService.getJobFamiliesByCapabilityName("");

        Mockito.verify(jobFamilyRepository).findByCapabilityName("");
        assertEquals(jobFamily, results);
    }

    @Test
    void when_UpdatingJobFamilyName_expect_RepositoryCalledPassbackFind() {
        Mockito.when(jobFamilyRepository.findById("Name")).thenReturn(Optional.of(jobFamily));

        jobFamilyService.updateJobFamilyName("Name", "Name");

        Mockito.verify(jobFamilyRepository).findById("Name");
    }

    @Test
    void when_UpdatingJobFamilyName_expect_RepositoryCalledPassbackDelete() {
        Mockito.when(jobFamilyRepository.findById("Name")).thenReturn(Optional.of(jobFamily));

        jobFamilyService.updateJobFamilyName("Name", "New Name");
        JobFamily actual = new JobFamily();
        actual.setName("New Name");

        Mockito.verify(jobFamilyRepository).deleteById("Name");
    }
    
    @Test
    void when_AddingValidJobFamily_expect_RepositoryCalledPassback() throws InvalidNameException, InstanceAlreadyExistsException {
        Capability capability = new Capability();
        JobFamily jobFamily = new JobFamily("Valid Job Family", capability);
        Mockito.when(jobFamilyRepository.save(jobFamily)).thenReturn(jobFamily);
        Mockito.when(capabilityService.capabilityExists(capability.getName())).thenReturn(true);

        JobFamily result = jobFamilyService.addJobFamily(jobFamily);
        Mockito.verify(jobFamilyRepository).save(jobFamily);

        assertEquals(jobFamily, result);
    }

    @Test
    void when_AddingInvalidJobFamilyWithValidCapability_expect_InvalidNameExceptionThrown() {
        Capability capability = new Capability();
        JobFamily jobFamily = new JobFamily("<Invalid Name>!", capability);
        Mockito.when(capabilityService.capabilityExists(capability.getName())).thenReturn(true);

        assertThrows(InvalidNameException.class, () -> jobFamilyService.addJobFamily(jobFamily));
    }

    @Test
    void when_AddingValidJobFamilyWithInvalidCapability_expect_CapabilityDoesNotExistExceptionThrown() {
        Capability capability = new Capability();
        JobFamily jobFamily = new JobFamily("Valid name", capability);
        Mockito.when(capabilityService.capabilityExists(capability.getName())).thenReturn(false);

        assertThrows(CapabilityDoesNotExistException.class, () -> jobFamilyService.addJobFamily(jobFamily));
    }

    @Test
    void when_AddingInvalidJobFamilyWithInvalidCapability_expect_CapabilityDoesNotExistExceptionThrown() {
        Capability capability = new Capability();
        JobFamily jobFamily = new JobFamily("!invalid?", capability);
        Mockito.when(capabilityService.capabilityExists(capability.getName())).thenReturn(false);

        assertThrows(CapabilityDoesNotExistException.class, () -> jobFamilyService.addJobFamily(jobFamily));
    }

    @Test
    void when_AddingBlankJobFamily_expectInvalidNameExceptionThrown() {
        Capability capability = new Capability();
        JobFamily jobFamily = new JobFamily("", capability);
        Mockito.when(capabilityService.capabilityExists(capability.getName())).thenReturn(true);

        assertThrows(InvalidNameException.class, () -> jobFamilyService.addJobFamily(jobFamily));
    }

    @Test
    void when_AddingExistingJobFamily_expect_InstanceAlreadyExistsExceptionThrown() {
        String jobFamilyName = "Existing job family";
        String capabilityName = "Existing capability";
        Capability capability = new Capability(capabilityName);
        JobFamily existingJobFamily = new JobFamily(jobFamilyName, capability);
        JobFamily newJobFamily = new JobFamily(jobFamilyName, capability);
        List<JobFamily> jobFamilies = List.of(existingJobFamily);
        Mockito.when(capabilityService.capabilityExists(capability.getName())).thenReturn(true);
        Mockito.when(jobFamilyRepository.findByNameAndCapabilityName(jobFamilyName, capabilityName)).thenReturn(jobFamilies);

        assertThrows(InstanceAlreadyExistsException.class, () -> jobFamilyService.addJobFamily(newJobFamily));
    }

    @Test
    void when_CheckingExistingJobFamily_expect_JobFamilyExistsReturnsTrue() {
        String jobFamilyName = "Existing job family";
        String capabilityName = "Existing capability";
        Capability capability = new Capability(capabilityName);
        JobFamily existingJobFamily = new JobFamily(jobFamilyName, capability);
        List<JobFamily> jobFamilies = List.of(existingJobFamily);
        Mockito.when(jobFamilyRepository.findByNameAndCapabilityName(jobFamilyName, capabilityName)).thenReturn(jobFamilies);

        boolean result = jobFamilyService.jobFamilyExists(jobFamilyName, capabilityName);
        Mockito.verify(jobFamilyRepository).findByNameAndCapabilityName(jobFamilyName, capabilityName);

        Assertions.assertTrue(result);
    }

    @Test
    void when_CheckingNewJobFamily_expect_JobFamilyExistsReturnsFalse() {
        String jobFamilyName = "New job family";
        String capabilityName = "Existing capability";
        List<JobFamily> jobFamilies = List.of();
        Mockito.when(jobFamilyRepository.findByNameAndCapabilityName(jobFamilyName, capabilityName)).thenReturn(jobFamilies);

        boolean result = jobFamilyService.jobFamilyExists(jobFamilyName, capabilityName);
        Mockito.verify(jobFamilyRepository).findByNameAndCapabilityName(jobFamilyName, capabilityName);

        Assertions.assertFalse(result);
    }

    @Test
    void when_DeletingInvalidJobFamily_expect_ThrowsException() {
        doThrow(EmptyResultDataAccessException.class).when(jobFamilyRepository).deleteById("");

        assertThrows(EmptyResultDataAccessException.class, () -> jobFamilyService.deleteJobFamily(""), "Should throw EmptyResultDataAccessException");
    }

    @Test
    void when_DeletingJobFamily_expect_DoesNotThrowException() {
        doNothing().when(jobFamilyRepository).deleteById("");

        assertDoesNotThrow(() -> jobFamilyService.deleteJobFamily(""), "Should" +
                " not throw an exception");
    }
}
