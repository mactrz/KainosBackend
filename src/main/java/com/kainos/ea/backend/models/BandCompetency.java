package com.kainos.ea.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "BandCompetency")
public class BandCompetency {

    @Id
    @Column(name = "bandCompetencyId")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bandName")
    private Band band;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "competencyName")
    private Competency competency;

    @Column(name = "description")
    private String description;

    @Column(name = "competencyMainName")
    private String mainName;

    public BandCompetency() {
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Competency getCompetency() {
        return competency;
    }

    public void setCompetency(Competency competency) {
        this.competency = competency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BandCompetency{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
