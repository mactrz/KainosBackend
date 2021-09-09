package com.kainos.ea.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "Training")
public class Training {

    public enum TrainingType {
        DEVELOPMENT_PROGRAMME,
        PROFESSIONAL_SKILLS,
        TECHNICAL_SKILLS
    }

    @Id
    @Column(name = "trainingID")
    private short ID;

    @Column(name = "trainingName")
    private String name;

    @Column(name = "trainingType")
    @Enumerated(EnumType.STRING)
    private TrainingType type;

    @Column(name = "sharepointURL")
    private String sharepointURL;

    public Training() {}

    public Training(short trainingID, String trainingName, TrainingType trainingType, String sharepointURL) {
        this.ID = trainingID;
        this.name = trainingName;
        this.type = trainingType;
        this.sharepointURL = sharepointURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainingType getType() {
        return type;
    }

    public void setType(TrainingType type) {
        this.type = type;
    }

    public String getSharepointURL() {
        return sharepointURL;
    }

    public void setSharepointURL(String sharepointURL) {
        this.sharepointURL = sharepointURL;
    }

    @Override
    public String toString() {
        return "Training{" +
                "trainingID=" + ID +
                ", trainingName='" + name + '\'' +
                ", trainingType=" + type +
                ", sharepointURL='" + sharepointURL + '\'' +
                '}';
    }
}
