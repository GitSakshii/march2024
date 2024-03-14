create table Person (
    Id int,
    Email varchar(255)
);


insert into person values
(1, 'a@b.com'),
(2, 'c@d.com'),
(3, 'a@b.com');

select email 
from person 
group by email
having count(*)>1;