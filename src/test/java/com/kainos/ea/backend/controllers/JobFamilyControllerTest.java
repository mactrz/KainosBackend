package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.JobFamily;
import com.kainos.ea.backend.services.JobFamilyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class JobFamilyControllerTest {

    @Mock
    private JobFamilyService jobFamilyService;

    @Test
    public void whenQueryingDataJobs_expect_ServiceCalledPassback() {
        Iterable<JobFamily> jobFamily = List.of(new JobFamily());
        Mockito.when(jobFamilyService.getJobFamiliesByCapabilityName("")).thenReturn(jobFamily);
        JobFamilyController jobFamilyController = new JobFamilyController(jobFamilyService);

        Iterable<JobFamily> results = jobFamilyController.getJobFamiliesByCapabilityName("");

        Mockito.verify(jobFamilyService).getJobFamiliesByCapabilityName("");
        assertEquals(jobFamily, results);
    }
}