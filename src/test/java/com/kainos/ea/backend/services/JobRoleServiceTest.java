package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.Band;
import com.kainos.ea.backend.models.Capability;
import com.kainos.ea.backend.models.JobRole;
import com.kainos.ea.backend.repositories.JobRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JobRoleServiceTest {

    @Mock
    private JobRoleRepository jobRoleRepository;
    @Mock
    private CapabilityService capabilityService;
    @Mock
    private BandService bandService;

    private JobRoleService jobRoleService;

    @BeforeEach
    public void setUp() {
        jobRoleService = new JobRoleService(jobRoleRepository, bandService, capabilityService);
    }

    @Test
    public void when_QueryingAllJobRolesSortedByCapability_expect_RepositoryCalledPassback() {
        List<JobRole> jobRoles = List.of(new JobRole());
        Mockito.when(jobRoleRepository.findAllByOrderByCapability()).thenReturn(jobRoles);

        List<JobRole> results = jobRoleService.getAllJobRolesSortedByCapability();

        Mockito.verify(jobRoleRepository).findAllByOrderByCapability();
        assertEquals(jobRoles, results);
    }

    @Test
    public void when_DeletingJobRole_expect_RepositoryCalledPassback() {
        jobRoleService.deleteJobRole(1);

        Mockito.verify(jobRoleRepository).deleteById(1);
    }

    @Test
    public void when_AddingNewJobRoleWithInvalidName_expect_IllegalArgumentExceptionWithAppropriateMessage() {
        JobRole jobRole = new JobRole();
        jobRole.setName("Test!! name");

        assertThrows(IllegalArgumentException.class, () -> jobRoleService.addJobRole(jobRole), "Invalid role name!");
    }
    @Test
    public void when_AddingNewJobRoleWithInvalidSpecification_expect_IllegalArgumentExceptionWithAppropriateMessage(){
        JobRole jobRole = new JobRole();
        jobRole.setName("Test name");
        jobRole.setSpecification("Test specifica???%%%tion");
        JobRoleService jobRoleService = new JobRoleService(jobRoleRepository, bandService, capabilityService);

        assertThrows(IllegalArgumentException.class, () -> jobRoleService.addJobRole(jobRole), "Invalid specification!");
    }
    @Test
    public void when_AddingNewJobRoleWithInvalidBand_expect_IllegalArgumentExceptionWithAppropriateMessage() {
        JobRole jobRole = new JobRole();
        jobRole.setName("Test name");
        jobRole.setSpecification("Test specification");
        Band band = new Band();
        band.setName("Name");
        jobRole.setBand(band);
        Mockito.when(bandService.getBandByName("Name")).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> jobRoleService.addJobRole(jobRole), "Band with given name does not exist!");
    }
    @Test
    public void when_AddingNewJobRoleWithInvalidCapability_expect_IllegalArgumentExceptionWithAppropriateMessage(){
        JobRole jobRole = new JobRole();
        jobRole.setName("Test name");
        jobRole.setSpecification("Test specification");
        Band band = new Band();
        band.setName("Name");
        Mockito.when(bandService.getBandByName("Name")).thenReturn(Optional.of(band));
        jobRole.setBand(band);
        Capability capability = new Capability();
        capability.setName("Name");
        jobRole.setCapability(capability);
        Mockito.when(capabilityService.getCapabilityByName("Name")).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> jobRoleService.addJobRole(jobRole), "Capability with given name does not exist!");
    }

    @Test
    public void when_ThereIsAnErrorWhenAddingNewJobRoleWithCorrectData_expect_IllegalArgumentExceptionWithAppropriateMessage(){
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
        Mockito.when(jobRoleRepository.save(jobRole)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> jobRoleService.addJobRole(jobRole), "There was an error while adding a job role! Please, try again later.");
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
        Mockito.when(jobRoleRepository.save(jobRole)).thenReturn(jobRole);

        assertDoesNotThrow(() -> jobRoleService.addJobRole(jobRole));
    }
}