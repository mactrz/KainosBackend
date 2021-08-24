package com.kainos.ea.backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Training")
public class Training {

    public enum TrainingType {
        PROFESSIONAL_SKILLS,
        TECHNICAL_SKILLS,
        DEVELOPMENT_PROGRAMME
    }

    @Id
    @Column(name = "trainingID")
    private short trainingID;

    @Column(name = "trainingName")
    private String trainingName;

    @Column(name = "trainingType")
    @Enumerated(EnumType.STRING)
    private TrainingType trainingType;

    @Column(name = "sharepointURL")
    private String sharepointURL;

    public Training() {}

    public Training(short trainingID, String trainingName, TrainingType trainingType, String sharepointURL) {
        this.trainingID = trainingID;
        this.trainingName = trainingName;
        this.trainingType = trainingType;
        this.sharepointURL = sharepointURL;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
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
                "trainingID=" + trainingID +
                ", trainingName='" + trainingName + '\'' +
                ", trainingType=" + trainingType +
                ", sharepointURL='" + sharepointURL + '\'' +
                '}';
    }
}
