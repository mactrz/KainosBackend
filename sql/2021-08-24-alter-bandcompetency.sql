ALTER TABLE BandCompetency add description varchar(350) not null;

INSERT INTO Competency(competencyName)
VALUES ('Developing self-awareness'),
('Managing yourself'),
('Continuing personal development'),
('Acting with integrity');

INSERT INTO Band(bandName)
values
('Apprentice'),
('Senior Associate'),
('Consultant');

INSERT INTO BandCompetency(bandName, competencyName, description)
values
('Apprentice', 'Developing self-awareness', 'Understands own strengths and areas of development. Self-aware of own well being and seeks support where appropriate.'),
('Apprentice', 'Managing yourself', 'Works with People Manager to sets and achieve goals by monitoring progress regularly against performance.'),
('Apprentice', 'Continuing personal development', 'Flexible and willingness to learn on the job while proactively keeping up to date with the knowledge and skills needed.'),
('Apprentice', 'Acting with integrity', 'Understands the company values and applies this to own principles. Is open and honest and acts respectfully with others and customer'),
('Trainee', 'Developing self-awareness', 'Understands others strengths and areas for development. Recognising diversity and its value within self and team. Proactively uses wellbeing tools to support self-regulation.'),
('Trainee', 'Managing yourself', 'Able to identify own goals and discusses these with People Manager. Understands the need to work conscientiously to achieve tasks on schedule.'),
('Trainee', 'Continuing personal development', 'Identifies learning gaps and seeks out opportunities to improve skills. Open to developmental feedback from others.'),
('Trainee', 'Acting with integrity', 'Demonstrates positive behaviours when dealing with others and ensures application of the values while working and representing Kainos to our customers.'),
('Associate', 'Developing self-awareness', 'Seeks out new challenges and opportunities that may stretch current abilities. Builds on own self-awareness of overall wellbeing.'),
('Associate', 'Managing yourself', 'Recognises the need for SMART goals, and demonstrates a “can do” attitude, through having own internal standards of performance.'),
('Associate', 'Continuing personal development', 'Seeks out opportunities to improve skills beyond the role scope whilst also seeking regular feedback.'),
('Associate', 'Acting with integrity', 'Encourages positive behaviours in others, while role modelling the Kainos values.'),
('Senior Associate', 'Developing self-awareness', 'Understands and confidently articulates own learning and developmental needs and proactively seek opportunities to gain experience.Has a strong level of self-awareness and in tune with own wellbeing needs and intuitive of others.'),
('Senior Associate', 'Managing yourself', 'Seeks and responds positively to feedback regarding own learning and development. Approach with a willingness to take on tasks that are outside role scope.'),
('Senior Associate', 'Continuing personal development', 'Looks for opportunities to take on new challenges while proactively supporting and encouraging others in identifying learning needs.'),
('Senior Associate', 'Acting with integrity', 'Recognises inappropriate behaviours and challenges constructively while promoting the Kainos values. Adapting behaviours and acting in the most appropriate way'),
('Consultant', 'Developing self-awareness', 'Understands own personal preferences, biases and values different cultures, backgrounds and circumstances in decision making and takes actions. Champions Kainos wellbeing offerings and provides direction to the various wellbeing guides and support available for our people.'),
('Consultant', 'Managing yourself', 'Consistently sets own goals and manages this independently. Making autonomous decisions and are able to ‘get on with the job’ escalating decisions only when appropriate.'),
('Consultant', 'Continuing personal development', 'Identifies and addresses team or individual capability requirements and gaps to deliver current and future work. Consistently identifies and develops self and others to support talent development.'),
('Consultant', 'Acting with integrity', 'Demonstrates professional and organisational values through actions and behaviours. Behaves in an inclusive manner and respects equality and diversity.');

