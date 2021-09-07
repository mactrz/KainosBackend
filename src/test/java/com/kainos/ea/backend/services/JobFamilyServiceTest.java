package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.JobFamilyRepository;
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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class JobFamilyServiceTest {
    @Mock
    private JobFamilyRepository jobFamilyRepository;

    @Test
    void when_getJobFamiliesByCapabilityName_expect_RepositoryCalledPassback() {
        List<JobFamily> jobFamily = List.of(new JobFamily());
        Mockito.when(jobFamilyRepository.findByCapabilityName("")).thenReturn(jobFamily);
        JobFamilyService jobFamilyService = new JobFamilyService(jobFamilyRepository);

        List<JobFamily> results = jobFamilyService.getJobFamiliesByCapabilityName("");

        Mockito.verify(jobFamilyRepository).findByCapabilityName("");
        assertEquals(jobFamily, results);
    }

    @Test
    void when_deleteInvalidJobFamily_expect_ThrowsException() {
        doThrow(EmptyResultDataAccessException.class).when(jobFamilyRepository).deleteById("");
        JobFamilyService jobFamilyService = new JobFamilyService(jobFamilyRepository);

        assertThrows(EmptyResultDataAccessException.class, () -> jobFamilyService.deleteJobFamily(""), "Should throw EmptyResultDataAccessException");
    }

    @Test
    void when_deleteJobFamily_expect_DoesNotThrowException() {
        doNothing().when(jobFamilyRepository).deleteById("");
        JobFamilyService jobFamilyService = new JobFamilyService(jobFamilyRepository);

        assertDoesNotThrow(() -> jobFamilyService.deleteJobFamily(""), "Should" +
                " not throw an exception");
    }
}