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

CREATE TABLE `BandCompetency` (
  `bandCompetencyId` smallint NOT NULL AUTO_INCREMENT,
  `bandName` varchar(50) NOT NULL,
  `competencyName` varchar(100) NOT NULL,
  `description` varchar(300) NOT NULL,
  `competencyMainName` varchar(50) NOT NULL,
  PRIMARY KEY (`bandCompetencyId`),
  KEY `bandName` (`bandName`),
  KEY `competencyName` (`competencyName`),
  CONSTRAINT `BandCompetency_ibfk_1` FOREIGN KEY (`bandName`) REFERENCES `Band` (`bandName`),
  CONSTRAINT `BandCompetency_ibfk_2` FOREIGN KEY (`competencyName`) REFERENCES `Competency` (`competencyName`)
)

INSERT INTO BandCompetency(bandName, competencyName, description, competencyMainName)
values
('Apprentice', 'Developing self-awareness', 'Understands own strengths and areas of development. Self-aware of own well being and seeks support where appropriate.', 'Personal Performance'),
('Apprentice', 'Managing yourself', 'Works with People Manager to sets and achieve goals by monitoring progress regularly against performance.', 'Personal Performance'),
('Apprentice', 'Continuing personal development', 'Flexible and willingness to learn on the job while proactively keeping up to date with the knowledge and skills needed.', 'Personal Performance'),
('Apprentice', 'Acting with integrity', 'Understands the company values and applies this to own principles. Is open and honest and acts respectfully with others and customer', 'Personal Performance'),
('Trainee', 'Developing self-awareness', 'Understands others strengths and areas for development. Recognising diversity and its value within self and team. Proactively uses wellbeing tools to support self-regulation.', 'Personal Performance'),
('Trainee', 'Managing yourself', 'Able to identify own goals and discusses these with People Manager. Understands the need to work conscientiously to achieve tasks on schedule.', 'Personal Performance'),
('Trainee', 'Continuing personal development', 'Identifies learning gaps and seeks out opportunities to improve skills. Open to developmental feedback from others.', 'Personal Performance'),
('Trainee', 'Acting with integrity', 'Demonstrates positive behaviours when dealing with others and ensures application of the values while working and representing Kainos to our customers.', 'Personal Performance'),
('Associate', 'Developing self-awareness', 'Seeks out new challenges and opportunities that may stretch current abilities. Builds on own self-awareness of overall wellbeing.', 'Personal Performance'),
('Associate', 'Managing yourself', 'Recognises the need for SMART goals, and demonstrates a “can do” attitude, through having own internal standards of performance.', 'Personal Performance'),
('Associate', 'Continuing personal development', 'Seeks out opportunities to improve skills beyond the role scope whilst also seeking regular feedback.', 'Personal Performance'),
('Associate', 'Acting with integrity', 'Encourages positive behaviours in others, while role modelling the Kainos values.', 'Personal Performance'),
('Senior Associate', 'Developing self-awareness', 'Understands and confidently articulates own learning and developmental needs and proactively seek opportunities to gain experience.Has a strong level of self-awareness and in tune with own wellbeing needs and intuitive of others.', 'Personal Performance'),
('Senior Associate', 'Managing yourself', 'Seeks and responds positively to feedback regarding own learning and development. Approach with a willingness to take on tasks that are outside role scope.', 'Personal Performance'),
('Senior Associate', 'Continuing personal development', 'Looks for opportunities to take on new challenges while proactively supporting and encouraging others in identifying learning needs.', 'Personal Performance'),
('Senior Associate', 'Acting with integrity', 'Recognises inappropriate behaviours and challenges constructively while promoting the Kainos values. Adapting behaviours and acting in the most appropriate way', 'Personal Performance'),
('Consultant', 'Developing self-awareness', 'Understands own personal preferences, biases and values different cultures, backgrounds and circumstances in decision making and takes actions. Champions Kainos wellbeing offerings and provides direction to the various wellbeing guides and support available for our people.', 'Personal Performance'),
('Consultant', 'Managing yourself', 'Consistently sets own goals and manages this independently. Making autonomous decisions and are able to ‘get on with the job’ escalating decisions only when appropriate.', 'Personal Performance'),
('Consultant', 'Continuing personal development', 'Identifies and addresses team or individual capability requirements and gaps to deliver current and future work. Consistently identifies and develops self and others to support talent development.', 'Personal Performance'),
('Consultant', 'Acting with integrity', 'Demonstrates professional and organisational values through actions and behaviours. Behaves in an inclusive manner and respects equality and diversity.', 'Personal Performance');

INSERT INTO BandCompetency(bandName, competencyName, description, competencyMainName)
values
('Apprentice', 'Mobilises self and others to drive self-improvement', 'Understand how to respond constructively to developmental feedback from a diverse range of people and implement changes as a result.', 'Working with Others'),
('Apprentice', 'Champions continuous improvement', 'Displays high levels of enthusiasm, energy and pace to achieve performance and results.', 'Working with Others'),
('Apprentice', 'Developing networks and building and maintaining relationships', 'Recognises the need to build internal networks within immediate teams and projects', 'Working with Others'),
('Apprentice', 'Working within teams', 'Respects others by attending meetings on time and contributing where appropriate. Recognising how current role relates to', 'Working with Others'),
('Trainee', 'Mobilises self and others to drive self-improvement', 'Shares learning with the team and other colleagues, contributing to the team’s understanding.', 'Working with Others'),
('Trainee', 'Champions continuous improvement', 'Maintains consistent performance, challenging self and others to be positive and focused on achieving results,despite setbacks. Support others to work in a way that is mutually supportive', 'Working with Others'),
('Trainee', 'Developing networks and building and maintaining relationships', 'Builds strong working relationships within team and project teams and start to consider building a wider network.Consistently collaborates within immediate teams and finds opportunities to build rapport and trust while supporting others.', 'Working with Others'),
('Trainee', 'Working within teams', 'Aware of the consequences of own behaviour and how this may affect others within the team. Supports the sharing of knowledge.', 'Working with Others'),
('Associate', 'Mobilises self and others to drive self-improvement', 'Actively take opportunities to learn from a diverse range of people, to maximise performance and mentor/coach more junior colleagues.', 'Working with Others'),
('Associate', 'Champions continuous improvement', 'Is creative in finding ways to learn and personally improve results,suggesting new approaches to benefit self and the team. Review progress against goals making necessary adjustments to deliver successfully.', 'Working with Others'),
('Associate', 'Developing networks and building and maintaining relationships', 'Consistently collaborates within immediate teams and finds opportunities to build rapport and trust while supporting others. Proactively contribute to the work of the whole team whilst building positive colleague relationships', 'Working with Others'),
('Associate', 'Working within teams', 'Actively participates and cooperates to support others within the team to achieve common goals. Able to interact effectively in stressful or frustrating', 'Working with Others'),
('Senior Associate', 'Mobilises self and others to drive self-improvement', 'Proactively supports the development of other team members while identifying opportunities to increase innovation to achieve team’s objectives.', 'Working with Others'),
('Senior Associate', 'Champions continuous improvement', 'Encourages both formal and informal learning opportunities, ensuring others take responsibility for own learning and share this to increase organisational capability. Support and stretches self and others to deliver agreed goals and objectives', 'Working with Others'),
('Senior Associate', 'Developing networks and building and maintaining relationships', 'Effectively builds wider networks across projects, Capabilities and BUs and constructively challenges colleagues including those in positions of authority.', 'Working with Others'),
('Senior Associate', 'Working within teams', 'Encourages collaborative team working within immediate teams and across the whole business. Supports an environment where others can make mistakes and learn from it.', 'Working with Others'),
('Consultant', 'Mobilises self and others to drive self-improvement', 'Support and empower team members through a range of activities to include coaching and mentoring. Demonstrate that leadership and technical skills are equally valued', 'Working with Others'),
('Consultant', 'Champions continuous improvement', 'Role model continuous learning and self-development, evaluating own effectiveness and growth.Motivate others to achieve through challenging times. Regularly monitor and discuss own and team’s performance expectations defined within the performance management system.', 'Working with Others'),
('Consultant', 'Developing networks and building and maintaining relationships', 'Builds a strong network of collaborative relationships, in order to achieve objectives, whilst supporting wider stakeholder agendas.Recognised as an active mentor and coach and can demonstrate examples of coaching others in immediate teams to improve performance.', 'Working with Others'),
('Consultant', 'Working within teams', 'Encourages involvement from others to deliver through collaboration better results for Kainos. Recognises and builds on individual strengths of colleagues and team', 'Working with Others');

insert into Competency(competencyName)
values
('Developing self-awareness'),
('Managing yourself'),
('Continuing personal development'),
('Acting with integrity'),
('Mobilises self and others to drive self-improvement'),
('Champions continuous improvement'),
('Developing networks and building and maintaining relationships'),
('Working within teams');