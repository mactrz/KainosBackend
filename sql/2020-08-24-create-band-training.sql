CREATE TABLE Training (
    trainingID SMALLINT PRIMARY KEY,
    trainingName VARCHAR(255) NOT NULL,
    trainingType ENUM('PROFESSIONAL_SKILLS', 'TECHNICAL_SKILLS', 'DEVELOPMENT_PROGRAMME') NOT NULL,
    sharepointURL VARCHAR(150) NOT NULL
);

CREATE TABLE BandTraining (
    bandTrainingID SMALLINT PRIMARY KEY,
    bandName VARCHAR(50) NOT NULL,
    trainingID SMALLINT NOT NULL,
    FOREIGN KEY (bandName) REFERENCES Band(bandName) ON DELETE CASCADE,
    FOREIGN KEY (trainingID) REFERENCES Training(trainingID) ON DELETE CASCADE
);

INSERT INTO Training (trainingID, trainingName, trainingType, sharepointURL) VALUES (1, 'Example Training', 'PROFESSIONAL_SKILLS', 'www.google.com');
INSERT INTO BandTraining (bandTrainingID, bandName, trainingID) VALUES (1, 'Apprentice', 1);