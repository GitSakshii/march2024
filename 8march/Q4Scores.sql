CREATE TABLE Scores (
    Id INT,
    Score DECIMAL(5, 2)
);

insert into Scores (Id, Score) values
(1, 3.50),
(2, 3.65),
(3, 4.00),
(4, 3.85),
(5, 4.00),
(6, 3.65);
SELECT 
    Score,
    (SELECT COUNT(DISTINCT Score) 
     FROM Scores s2 
     WHERE s2.Score >= s1.Score) as 'rank'
FROM 
    Scores s1
ORDER BY 
    Score DESC;

