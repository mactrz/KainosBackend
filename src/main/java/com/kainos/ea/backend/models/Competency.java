package com.kainos.ea.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Competency {

    @Id
    @Column(name = "competencyName")
    private String competencyName;

    public Competency(){}

    public Competency(String competencyName) {
        this.competencyName = competencyName;
    }

    public String getCompetencyName() {
        return competencyName;
    }

    public void setCompetencyName(String competencyName) {
        this.competencyName = competencyName;
    }
}
