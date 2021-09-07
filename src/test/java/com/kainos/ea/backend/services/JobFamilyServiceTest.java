package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.repositories.JobFamilyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JobFamilyServiceTest {
    @Mock
    private JobFamilyRepository jobFamilyRepository;
    private JobFamilyService jobFamilyService;
    private JobFamily jobFamily;

    @BeforeEach
    public void setUp() {
        jobFamilyService = new JobFamilyService(jobFamilyRepository);
        jobFamily = new JobFamily();
        jobFamily.setName("Name");
    }

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
    public void when_updateJobFamilyName_expect_RepositoryCalledPassbackFind() {
        Mockito.when(jobFamilyRepository.findById("Name")).thenReturn(Optional.of(jobFamily));

        jobFamilyService.updateJobFamilyName("Name", "Name");

        Mockito.verify(jobFamilyRepository).findById("Name");
    }

    @Test
    public void when_updateJobFamilyName_expect_RepositoryCalledPassbackDelete() {
        Mockito.when(jobFamilyRepository.findById("Name")).thenReturn(Optional.of(jobFamily));

        jobFamilyService.updateJobFamilyName("Name", "New Name");
        JobFamily actual = new JobFamily();
        actual.setName("New Name");

        Mockito.verify(jobFamilyRepository).deleteById("Name");
    }

}