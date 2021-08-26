package com.kainos.ea.backend.models;

import javax.persistence.*;
import java.util.Objects;

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
  
    /*
     *       CONSTRUCTORS
     * */

    public Capability() {}
      
    public Capability(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    /*
     *       OVERRIDDEN METHODS
     * */

    @Override
    public String toString() {
        return "Capability{" +
                "capabilityName='" + capabilityName + '\'' +
                ", leadName='" + leadName + '\'' +
                ", leadPhoto='" + leadPhoto + '\'' +
                ", leadMessage='" + leadMessage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capability that = (Capability) o;
        return name.equals(that.name) && leadName.equals(that.leadName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, leadName);
    }

    /*
     *       GETTERS AND SETTERS
     * */

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;

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
}
