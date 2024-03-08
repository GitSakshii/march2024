CREATE TABLE Points (
    x INT
);
INSERT INTO Points (x) VALUES
(-1),
(0),
(2);

SELECT MIN(ABS(p1.x - p2.x)) AS shortest
FROM Points p1
CROSS JOIN Points p2
WHERE p1.x <> p2.x;