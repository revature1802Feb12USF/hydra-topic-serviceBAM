INSERT INTO TOPIC(TOPIC_ID, TOPIC_NAME) VALUES (50, 'Java');
 
INSERT INTO TOPIC(TOPIC_ID, TOPIC_NAME) VALUES (51, 'SQL');

INSERT INTO SUBTOPIC(ID, NAME, STATUS, PARENT_TOPIC) VALUES (1000, 'Loops', 'Completed', 50);

INSERT INTO SUBTOPIC(ID, NAME, STATUS, PARENT_TOPIC) VALUES (1001, 'OOP', 'Missed', 50);

INSERT INTO SUBTOPIC(ID, NAME, STATUS, PARENT_TOPIC) VALUES (1002, 'Select Queries', 'Planned', 51);

INSERT INTO SUBTOPIC(ID, NAME, STATUS, PARENT_TOPIC) VALUES (1003, 'Joins', 'Planned', 51);