CREATE TABLE Student (
    name VARCHAR(50),
    continent VARCHAR(50)
);
INSERT INTO Student (name, continent) VALUES
('Jack', 'America'),
('Pascal', 'Europe'),
('Xi', 'Asia'),
('Jane', 'America');

SELECT 
    MAX(CASE WHEN continent = 'America' THEN name END) AS America,
    MAX(CASE WHEN continent = 'Asia' THEN name END) AS Asia,
    MAX(CASE WHEN continent = 'Europe' THEN name END) AS Europe
FROM 
    Student;