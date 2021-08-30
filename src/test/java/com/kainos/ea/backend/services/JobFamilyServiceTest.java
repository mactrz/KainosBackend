package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.JobFamilyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}