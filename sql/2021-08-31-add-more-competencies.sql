CREATE TABLE `Competency` (
  `competencyName` varchar(200) NOT NULL,
  PRIMARY KEY (`competencyName`)
)

insert into Competency(competencyName)
values
('Mobilises self and others to drive self-improvement'),
('Champions continuous improvement'),
('Developing networks and building and maintaining relationships'),
('Working within teams'),
('Developing self-awareness'),
('Managing yourself'),
('Continuing personal development'),
('Acting with integrity'),
('Mobilises people to drive business improvement & innovation'),
('Champions continuous improvement in self & others – creating a positive environment and encouraging contribution'),
('Managing performance'),
('Effective time management'),
('Promoting accountability'),
('Effective meetings'),
('Problem solving'),
('Supporting the strategy and vision'),
('Organisational awareness'),
('Cultural and ethical awareness'),
('Communicates effectively'),
('Influencing others'),
('Customer Focus and Stakeholder management'),
('Identifying the contexts for change'),
('Improvement and Innovation'),
('Making decisions'),
('Creating and Evaluating impact'),
('Framing the strategy'),
('Developing the strategy'),
('Implementing the strategy'),
('Embedding the strategy'),
('Demonstrates commercial awareness and behaviours'),
('Contributes to the ongoing development of new business to support Kainos’ growth ambitions'),
('Improves efficiency and effectiveness to drive profitability'),
('Manages risk to Kainos and the interest of our shareholders'),
('Promotes and adheres to Kainos process and policies'),
('Develops, communicates and promotes the Kainos vision and strategy'),
('Influencing the vision and beyond'),
('Influencing change and transformation'),
('Stakeholder management');

INSERT INTO BandCompetency(bandName, competencyName, description, competencyMainName)
values
('Apprentice', 'Effective time management', 'Understands role, tasks and deadlines and work towards these, escalating any issues where appropriate to People/Project Manager.', 'Setting Direction, Development and Accountability'),
('Apprentice', 'Promoting accountability', 'Accepts personal responsibility for quality and timelines of work set.', 'Setting Direction, Development and Accountability'),
('Apprentice', 'Effective meetings', 'Works to manage diary, commitments and ready to attend meetings on time.', 'Setting Direction, Development and Accountability'),
('Apprentice', 'Problem solving', 'Actively supports new initiatives and tries different ways of doing things, learning from others’ experiences.', 'Setting Direction, Development and Accountability'),
('Trainee', 'Effective time management', 'Plans time effectively to ensure deadlines are met, and seen to be honest, escalating in advance any issues with completing tasks within the specified time.', 'Setting Direction, Development and Accountability'),
('Trainee', 'Promoting accountability', 'Takes ownership of all responsibilities within own role and honours commitments to others and to Kainos.', 'Setting Direction, Development and Accountability'),
('Trainee', 'Effective meetings', 'Effectively manages diary, coming prepared for meetings and actively listen.', 'Setting Direction, Development and Accountability'),
('Trainee', 'Problem solving', 'Breaks down issues, and actively seeks further information and understanding.', 'Setting Direction, Development and Accountability'),
('Associate', 'Effective time management', 'Recognises how much time is required for different tasks and start to prioritise and communicate effectively within teams. Seeking appropriate support while supporting peers and junior team members.', 'Setting Direction, Development and Accountability'),
('Associate', 'Promoting accountability', 'Identifies commitments and proactively seeks responsibility in delivering towards the wider team and project objectives.', 'Setting Direction, Development and Accountability'),
('Associate', 'Effective meetings', 'Establishes effective meetings through setting an agenda and coming prepared and speaking on projects calls where appropriate. Follows up and delivers upon actions from meetings.', 'Setting Direction, Development and Accountability'),
('Associate', 'Problem solving', 'Makes suggestions for improvements to personal work and processes', 'Setting Direction, Development and Accountability'),
('Senior Associate', 'Effective time management', 'A strong ability to multitask and prioritise to deadlines, overcoming obstacles to ensure the work is completed within time. Researching and communicating in advance any barriers that may affect projects.', 'Setting Direction, Development and Accountability'),
('Senior Associate', 'Promoting accountability', 'Demonstrates individual responsibility for achieving objectives and able to articulate success, failures and proposing remedial actions.', 'Setting Direction, Development and Accountability'),
('Senior Associate', 'Effective meetings', 'Consistently prepared for meetings and effectively manages own diary for preparation and an agenda is set in advance. Actively seeks input from colleagues and challenges others where appropriate', 'Setting Direction, Development and Accountability'),
('Senior Associate', 'Problem solving', 'Processes and distils a variety of information to understand a problem fully while proposing options for solutions and building on the ideas of others.', 'Setting Direction, Development and Accountability'),
('Consultant', 'Effective time management', 'Develops effective systems to organise and track workload while, motivating and encouraging others to achieve planned results, delegating work to use people and resources to best effect. Ensuring colleagues are aware of any changing priorities and monitor progress', 'Setting Direction, Development and Accountability'),
('Consultant', 'Promoting accountability', 'Delegates authority to match responsibilities and holds staff accountable for agreed-upon commitments. Within immediate teams creates accountability by using experience and advice to guide others.', 'Setting Direction, Development and Accountability'),
('Consultant', 'Effective meetings', 'Sets an example of leading internal and external meetings through preparation, prioritisation, and considered agendas, ensuring any challenges and issues are discussed.', 'Setting Direction, Development and Accountability'),
('Consultant', 'Problem solving', 'Seeks the opinions and experiences of others to understand different approaches while thinking laterally about own work and encouraging creative problem solving.', 'Setting Direction, Development and Accountability');


INSERT INTO BandCompetency(bandName, competencyName, description, competencyMainName)
values
('Apprentice', 'Supporting the strategy and vision', 'Understands the Kainos Vision, Strategy and Principles.', 'Supporting and Delivering the Strategy'),
('Apprentice', 'Organisational awareness', 'Understands the organisation structure and the purpose of Kainos.', 'Supporting and Delivering the Strategy'),
('Apprentice', 'Cultural and ethical awareness', 'Possess general knowledge of local cultural differences and familiar with the Kainos policy towards Diversity and Inclusion.', 'Supporting and Delivering the Strategy'),
('Trainee', 'Supporting the strategy and vision', 'Recognises how to contribute to the wider organisational objectives and strategic principles.', 'Supporting and Delivering the Strategy'),
('Trainee', 'Organisational awareness', 'Pays attention to organisational information, how well we are doing and what is changing.', 'Supporting and Delivering the Strategy'),
('Trainee', 'Cultural and ethical awareness', 'Awareness of cultural differences and willingness to develop and grow understanding of global and cultural effectiveness.', 'Supporting and Delivering the Strategy'),
('Associate', 'Supporting the strategy and vision', 'Articulates individual contribution to the wider Kainos objectives and uses evidence by including SMART goals that align to the Capability/BU.', 'Supporting and Delivering the Strategy'),
('Associate', 'Organisational awareness', 'Clearly defines how individual personal performance can have an impact on the business achieving the vision and objectives.', 'Supporting and Delivering the Strategy'),
('Associate', 'Cultural and ethical awareness', 'Respects differences and promotes inclusion on a transactional level. Displays appropriate ethical behaviours and acknowledges own unconscious bias.', 'Supporting and Delivering the Strategy'),
('Senior Associate', 'Supporting the strategy and vision', 'Supports peers and team members in understanding the wider Kainos objectives and how we all have a role in Kainos’success.', 'Supporting and Delivering the Strategy'),
('Senior Associate', 'Organisational awareness', 'Recognises and reflects on how personal actions may have a wider impact on other people and teams.', 'Supporting and Delivering the Strategy'),
('Senior Associate', 'Cultural and ethical awareness', 'Demonstrates awareness and appreciation for the global multi-dimensional and diverse perspectives of our people. Provide a protective environment within immediate teams in which colleagues can escalate any issues while demonstrating impartial application of Kainos policies, procedure and practices.', 'Supporting and Delivering the Strategy'),
('Consultant', 'Supporting the strategy and vision', 'Balances own teams needs with wider organisational needs while translating the Vision and Strategy into practical and tangible goals.', 'Supporting and Delivering the Strategy'),
('Consultant', 'Organisational awareness', 'Effectively ensures immediate teams understand how their work contributes to and delivers organisational priorities.', 'Supporting and Delivering the Strategy'),
('Consultant', 'Cultural and ethical awareness', 'Consistently role models cultural effectiveness in the demonstration of ethical behaviours while understanding the value diversity brings to Kainos. Promoting diversity and inclusion within teams while adapting to the needs of our diverse people.', 'Supporting and Delivering the Strategy');


INSERT INTO BandCompetency(bandName, competencyName, description, competencyMainName)
values
('Apprentice', 'Demonstrates commercial awareness and behaviours', 'Understands the markets and sectors in which Kainos operates while acknowledging how role links in and has an impact on other teams and the business.', 'Commerciality and Risk'),
('Apprentice', 'Improves efficiency and effectiveness to drive profitability', 'Wiling to learn, and embrace new ideas, to improve processes and procedures.', 'Commerciality and Risk'),
('Apprentice', 'Promotes and adheres to Kainos process and policies', 'Cooperates with business processes completing accurately and honestly e.g., timesheets/EOY Review and travel requests.', 'Commerciality and Risk'),
('Trainee', 'Demonstrates commercial awareness and behaviours', 'Understands how the business generates income. Supporting the business by assisting in activities such as Recruitment events, Career fairs and Work experience mentoring. Keeps up to date with current trends relating to work.', 'Commerciality and Risk'),
('Trainee', 'Improves efficiency and effectiveness to drive profitability', 'Reviews current practices and constructive in implementing changes to own work.', 'Commerciality and Risk'),
('Trainee', 'Promotes and adheres to Kainos process and policies', 'Consistently cooperates with business processes completing accurately and honestly e.g., timesheets/EOY Review and travel requests.', 'Commerciality and Risk'),
('Associate', 'Demonstrates commercial awareness and behaviours', 'Comprehends the need for the business to generate additional income and respects that costs need to be managed. Recognises the contribution that role makes to the success of the business, consistently delivering to task deadlines.', 'Commerciality and Risk'),
('Associate', 'Improves efficiency and effectiveness to drive profitability', 'Acknowledges what is required to manage costs within the business. Considers and suggests ideas for improvements, sharing this feedback with others in a constructive manner.', 'Commerciality and Risk'),
('Associate', 'Promotes and adheres to Kainos process and policies', 'Constantly achieves personal productive utilisation targets. Appreciating how the team/project supports increased income for Kainos.', 'Commerciality and Risk'),
('Senior Associate', 'Demonstrates commercial awareness and behaviours', 'Demonstrates a clear understanding of how the business makes profit and how individual role effects profitability of the company. Respectfully challenges commercial decisions to contribute an increased profitability.', 'Commerciality and Risk'),
('Senior Associate', 'Improves efficiency and effectiveness to drive profitability', 'Manages and meets the expectations of customers without compromising budgets. Supports change in a constructive manner to help colleagues and stakeholders understand changes and why they have been introduced.', 'Commerciality and Risk'),
('Senior Associate', 'Promotes and adheres to Kainos process and policies', 'Understands the organisational structure of Kainos, reporting lines and can actively identify where key responsibilities lie.', 'Commerciality and Risk'),
('Consultant', 'Demonstrates commercial awareness and behaviours', 'Identifies potential new opportunities for Kainos to generate income and proactively takes action to progress. Understanding the commercial implications of changes in scope and negotiate with customers proactively. Able to look beyond the immediate problems/issues to see the impact on the bigger picture.', 'Commerciality and Risk'),
('Consultant', 'Improves efficiency and effectiveness to drive profitability', 'Uses financial information to find pragmatic new ways of saving cost/effort without reducing output. Review procedures or systems with immediate teams to identify improvements and simplify processes and decision making.', 'Commerciality and Risk'),
('Consultant', 'Promotes and adheres to Kainos process and policies', 'Recognise the impact of BU and company profitability and supports company decisions that affect +profit. Ensures own team are adhering to policies, processes, and procedures.', 'Commerciality and Risk');


INSERT INTO BandCompetency(bandName, competencyName, description, competencyMainName)
values
('Apprentice', 'Communicates effectively', 'Acts in a respectful manner in all forms of communication while being open and honest.Displays a positive approach when interacting with others.', 'Communicating and Influence'),
('Apprentice', 'Influencing others', 'Recognises influencing as a key skill required to work effectively with internal and external customers.', 'Communicating and Influence'),
('Apprentice', 'Customer Focus and Stakeholder management', 'Acts in accordance with the Kainos values demonstrating through own behaviours and interactions with colleagues and customers.', 'Communicating and Influence'),
('Trainee', 'Communicates effectively', 'Communicates own views in a clear and constructive manner, while listening to different views and considers all employees from various backgrounds.', 'Communicating and Influence'),
('Trainee', 'Influencing others', 'Observes team/colleagues influencing internally and externally and understands the benefits of adapting personal style to shape, motivate and influence effectively.', 'Communicating and Influence'),
('Trainee', 'Customer Focus and Stakeholder management', 'Understands who our customers are and what problems the team is trying to solve.', 'Communicating and Influence'),
('Associate', 'Communicates effectively', 'Involved at meetings, asking questions, listening and develops and presents a well-reasoned point of view. Remaining communicative and clear in own thoughts and ideas when approached by others, giving consideration to the communication needs of other staff and customers.', 'Communicating and Influence'),
('Associate', 'Influencing others', 'Demonstrates influencing skills internally and able to communicate points clearly and open to feedback from others.', 'Communicating and Influence'),
('Associate', 'Customer Focus and Stakeholder management', 'Demonstrates how to participate in stakeholder management, escalates effectively, and strives to provide a quality service and showcase Kainos positively.', 'Communicating and Influence'),
('Senior Associate', 'Communicates effectively', 'Recognises and respect that communication is a two-way process and demonstrate effective questioning and active listening skills to achieve this. Confidently handles challenging conversations and is clear and constructive in response.', 'Communicating and Influence'),
('Senior Associate', 'Influencing others', 'Persuades and influences with sound rationale argument ‘appealing to others’ interest or reason to gain support.', 'Communicating and Influence'),
('Senior Associate', 'Customer Focus and Stakeholder management', 'Authentic in stakeholder relationships and take pride in being inclusive and trustworthy while keeping promises made with customers. Responds honestly and promptly to customer requests and whenever possible within agreed timeframes.', 'Communicating and Influence'),
('Consultant', 'Communicates effectively', 'Uses communication to create a shared sense of purpose and direction. Adapting own style to effectively communicate and able to demonstrate this when difficult conversations have a positive outcome.', 'Communicating and Influence'),
('Consultant', 'Influencing others', 'Acts as an influential and effective member of multi-disciplinary teams or projects. Initiate’s collaboration and actively encourages people to cooperate in initiatives where they can add value.', 'Communicating and Influence'),
('Consultant', 'Customer Focus and Stakeholder management', 'Assesses customer needs accurately by listening and applying sensitive questioning. Managing customer expectations in relation to scope of work and are honest in what can and cannot be achieved within timescales. Confident in negotiating with customers to reflect changes in scope of work.', 'Communicating and Influence');
