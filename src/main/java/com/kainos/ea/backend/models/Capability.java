package com.kainos.ea.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Capability")
public class Capability {
    @Id
    @Column(name = "capabilityName")
    private String capabilityName;

    @Column(name = "leadName")
    private String leadName;

    @Column(name = "leadPhoto")
    private String leadPhoto;

    @Column(name = "leadMessage")
    private String leadMessage;

    public Capability() {
    }

    public Capability(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getLeadPhoto() {
        return leadPhoto;
    }

    public void setLeadPhoto(String leadPhoto) {
        this.leadPhoto = leadPhoto;
    }

    public String getLeadMessage() {
        return leadMessage;
    }

    public void setLeadMessage(String leadMessage) {
        this.leadMessage = leadMessage;
    }

    @Override
    public String toString() {
        return "Capability{" +
                "capabilityName='" + capabilityName + '\'' +
                ", leadName='" + leadName + '\'' +
                ", leadPhoto='" + leadPhoto + '\'' +
                ", leadMessage='" + leadMessage + '\'' +
                '}';
    }
}
