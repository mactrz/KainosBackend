package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.repositories.JobRolesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JobRoleServiceTest {

    @Mock
    private JobRolesRepository jobRolesRepository;
    @Mock
    private CapabilityService capabilityService;
    @Mock
    private BandService bandService;

    @Test
    public void when_QueryingAllJobRolesSortedByCapability_expect_ServiceCalledPassback(){
        List<JobRole> jobRoles = List.of(new JobRole());
        Mockito.when(jobRolesRepository.findAllByOrderByCapability()).thenReturn(jobRoles);
        JobRolesService jobRolesService = new JobRolesService(jobRolesRepository, bandService, capabilityService);

        List<JobRole> results = jobRolesService.getAllJobRolesSortedByCapability();

        Mockito.verify(jobRolesRepository).findAllByOrderByCapability();
        assertEquals(jobRoles, results);
    }

    @Test
    public void when_AddingNewJobRoleWithInvalidName_expect_ExceptionWithAppropriateMessage() {
        JobRole jobRole = new JobRole();
        jobRole.setName("Test!! name");
        JobRolesService jobRolesService = new JobRolesService(jobRolesRepository, bandService, capabilityService);

        assertThrows(Exception.class, () -> jobRolesService.addJobRole(jobRole), "Invalid role name!");
    }
    @Test
    public void when_AddingNewJobRoleWithInvalidSpecification_expect_ExceptionWithAppropriateMessage(){
        JobRole jobRole = new JobRole();
        jobRole.setName("Test name");
        jobRole.setSpecification("Test specifica/'/'/'/tion");

        JobRolesService jobRolesService = new JobRolesService(jobRolesRepository, bandService, capabilityService);

        assertThrows(Exception.class, () -> jobRolesService.addJobRole(jobRole), "Invalid specification!");
    }
    @Test
    public void when_AddingNewJobRoleWithInvalidBand_expect_ExceptionWithAppropriateMessage() {
        JobRole jobRole = new JobRole();
        jobRole.setName("Test name");
        jobRole.setSpecification("Test specification");
        Band band = new Band();
        band.setName("Name");
        Mockito.when(bandService.getBandByName("Name")).thenReturn(Optional.of(band));
        jobRole.setBand(band);

        JobRolesService jobRolesService = new JobRolesService(jobRolesRepository, bandService, capabilityService);

        assertThrows(Exception.class, () -> jobRolesService.addJobRole(jobRole), "Invalid specification!");
    }
    @Test
    public void when_AddingNewJobRoleWithInvalidCapability_expect_ExceptionWithAppropriateMessage(){
        JobRole jobRole = new JobRole();
        jobRole.setName("Test name");
        jobRole.setSpecification("Test specification");
        Band band = new Band();
        band.setName("Name");
        Mockito.when(bandService.getBandByName("Name")).thenReturn(Optional.of(band));
        jobRole.setBand(band);
        Capability capability = new Capability();
        capability.setName("Name");
        Mockito.when(capabilityService.getCapabilityByName("Name")).thenReturn(Optional.of(capability));
        jobRole.setCapability(capability);

        JobRolesService jobRolesService = new JobRolesService(jobRolesRepository, bandService, capabilityService);

        assertThrows(Exception.class, () -> jobRolesService.addJobRole(jobRole), "Invalid specification!");
    }

    @Test
    public void when_ThereIsAnErrorWhenAddingNewJobRoleWithCorrectData_expect_ExceptionWithAppropriateMessage(){
        JobRole jobRole = new JobRole();
        jobRole.setName("Test name");
        jobRole.setSpecification("Test specification");
        Band band = new Band();
        band.setName("Name");
        Mockito.when(bandService.getBandByName("Name")).thenReturn(Optional.of(band));
        jobRole.setBand(band);
        Capability capability = new Capability();
        capability.setName("Name");
        Mockito.when(capabilityService.getCapabilityByName("Name")).thenReturn(Optional.of(capability));
        jobRole.setCapability(capability);
        Mockito.when(jobRolesRepository.save(jobRole)).thenReturn(null);

        JobRolesService jobRolesService = new JobRolesService(jobRolesRepository, bandService, capabilityService);

        assertThrows(Exception.class, () -> jobRolesService.addJobRole(jobRole), "There was an error while adding a job role! Please, try again later.");
    }

    @Test
    public void when_AddingNewJobRoleWithCorrectData_expect_ExceptionNotThrown(){
        JobRole jobRole = new JobRole();
        jobRole.setName("Test name");
        jobRole.setSpecification("Test specification");
        Band band = new Band();
        band.setName("Name");
        Mockito.when(bandService.getBandByName("Name")).thenReturn(Optional.of(band));
        jobRole.setBand(band);
        Capability capability = new Capability();
        capability.setName("Name");
        Mockito.when(capabilityService.getCapabilityByName("Name")).thenReturn(Optional.of(capability));
        jobRole.setCapability(capability);
        Mockito.when(jobRolesRepository.save(jobRole)).thenReturn(jobRole);

        JobRolesService jobRolesService = new JobRolesService(jobRolesRepository, bandService, capabilityService);

        assertDoesNotThrow(() -> jobRolesService.addJobRole(jobRole));
    }
}