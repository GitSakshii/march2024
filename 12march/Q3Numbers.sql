CREATE TABLE my_numbers(num int);
insert into my_numbers values (8),(8),(3),(3),(1),(4),(5),(6);
SELECT MAX(num) AS num
FROM (
    SELECT num
    FROM my_numbers
    GROUP BY num
    HAVING COUNT(*) = 1
) AS unique_numbers;



