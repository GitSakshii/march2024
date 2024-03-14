create table friends (id int Primary key,name varchar(25),activity varchar(25));
create table activities(id int , name varchar(25));
insert into friends values
(1,'Jonathan D.', 'Eating'),
(2,'Jade W.','Singing' ),
(3,'Victor J.','Singing'),
(4,'Elvis Q.', 'Eating' ),
(5,'Daniel A.','Eating'),       
(6,'Bob B.','Horse Riding');

insert into activities values
( 1,'Eating'),(2,'Singing'),(3,'Horse Riding');

select activity from Friends group by activity
having count(id) not in
(
select max(cnt) as cnt from
    (select count(*) as cnt from Friends group by activity) as t1
union
select min(cnt) as cnt from
    (select count(*) as cnt from Friends group by activity) as t2
)