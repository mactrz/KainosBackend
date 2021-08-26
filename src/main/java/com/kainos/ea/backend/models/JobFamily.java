package com.kainos.ea.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "JobFamily")
public class JobFamily {

    @Id
    @Column(name = "jobFamilyName")
    private String jobFamilyName;

    @JoinColumn(name = "capabilityName")
    @ManyToOne
    private Capability capability;

    public JobFamily() {

    }

    public Capability getCapability() {
        return capability;
    }

    public void setCapability(Capability capability) {
        this.capability = capability;
    }

    public String getJobFamilyName() {
        return jobFamilyName;
    }

    public void setJobFamilyName(String jobFamilyName) {
        this.jobFamilyName = jobFamilyName;
    }

    @Override
    public String toString() {
        return "JobFamily{" +
                "jobFamilyName='" + jobFamilyName + '\'' +
                ", capabilityName='" + capability + '\'' +
                '}';
    }
}
