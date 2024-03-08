use avisoft;
CREATE TABLE calls(
    From_id INT,
    To_id INT,
    duration INT,
    CONSTRAINT d CHECK (From_id != To_id)
);
insert into calls
values(1,2,2),(2,3,3),(3,4,2);
select* from calls;