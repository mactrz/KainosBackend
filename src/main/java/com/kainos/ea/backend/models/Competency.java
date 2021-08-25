package com.kainos.ea.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Competency {

    @Id
    @Column(name = "competencyName")
    private String competencyName;

    @OneToMany(mappedBy = "competency")
    @JsonBackReference
    private Set<BandCompetency> description;

    public Competency(){}

    public Competency(String competencyName) {
        this.competencyName = competencyName;
    }

    public Set<BandCompetency> getDescription() {
        return description;
    }

    public void setDescription(Set<BandCompetency> description) {
        this.description = description;
    }

    public String getCompetencyName() {
        return competencyName;
    }

    public void setCompetencyName(String competencyName) {
        this.competencyName = competencyName;
    }

    @Override
    public String toString() {
        return competencyName;
    }
}
