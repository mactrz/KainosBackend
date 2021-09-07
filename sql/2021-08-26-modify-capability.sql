ALTER TABLE Capability MODIFY leadPhoto VARCHAR(255);

UPDATE Capability SET leadName = "Prof Brian Cox",
    leadPhoto = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcS5FXAyhXJaW9Epa1l8Hpz0VfmSjylO20Jplb8EIa36rXJIsFXS",
    leadMessage = "I love space"
    WHERE capabilityName = "Data";