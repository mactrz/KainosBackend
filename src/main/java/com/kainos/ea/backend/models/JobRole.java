package com.kainos.ea.backend.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "JobRole")
public class JobRole {

    @Id
    @GeneratedValue
    @Column(name = "jobRoleID")
    private Integer id;

    @Column(name = "jobRoleName")
    private String name;

    @Column(name = "specification")
    private String specification;

    @Column(name = "sharepointURL")
    private String sharepointUrl;

    @Column(name = "responsibilites")
    private String responsibilites;

    @ManyToOne
    @JoinColumn(name = "capabilityName")
    private Capability capability;

    @ManyToOne
    @JoinColumn(name = "bandName")
    private Band band;

    /*
     *       CONSTRUCTORS
     * */

    public JobRole() {}

    /*
     *       OVERRIDDEN METHODS
     * */

    @Override
    public String toString() {
        return "JobRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", sharepointUrl='" + sharepointUrl + '\'' +
                ", responsibilities='" + responsibilites + '\'' +
                ", capability=" + capability +
                ", band'" + band + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobRole jobRole = (JobRole) o;
        return id.equals(jobRole.id) && name.equals(jobRole.name) && capability.equals(jobRole.capability) && band.equals(jobRole.band);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capability, band);
    }

    /*
    *       GETTERS AND SETTERS
    * */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSharepointUrl() {
        return sharepointUrl;
    }

    public void setSharepointUrl(String sharepointUrl) {
        this.sharepointUrl = sharepointUrl;
    }

    public String getResponsibilities() {
        return responsibilites;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilites = responsibilities;
    }

    public Capability getCapability() {
        return capability;
    }

    public void setCapability(Capability capability) {
        this.capability = capability;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }
}
