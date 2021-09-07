ALTER TABLE BandTraining ADD COLUMN recommended BOOLEAN;

UPDATE BandTraining SET recommended = FALSE WHERE 1 = 1;
UPDATE BandTraining SET recommended = TRUE WHERE bandTrainingID % 2 = 0;
