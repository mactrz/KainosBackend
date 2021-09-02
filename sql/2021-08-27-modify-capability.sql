ALTER TABLE Capability MODIFY leadMessage VARCHAR(255);

UPDATE Capability SET leadName = "Mr Happy", leadPhoto = "https://static.wikia.nocookie.net/mrmen/images/6/6c/MR_HAPPY-3A.PNG", leadMessage = "I am very happy to be leading the Engineering capability" WHERE capabilityName = "Engineering";