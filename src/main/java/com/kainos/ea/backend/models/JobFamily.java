package com.kainos.ea.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "JobFamily")
public class JobFamily {

    @Id
    @Column(name = "jobFamilyName")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JobFamily{" +
                "jobFamilyName='" + name + '\'' +
                ", capabilityName='" + capability + '\'' +
                '}';
    }
}
