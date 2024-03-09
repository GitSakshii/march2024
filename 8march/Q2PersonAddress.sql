create table person (personId int,
FirstName varchar(25),
LastName varchar(25));
Alter table person
Add constraint pkpersonId primary key(personId);
insert into person 
values (1,"Sakshi","LastName"),(2,"Arya","Stark"),
(3,"Tyrion","Lannister");
create table address(addressId int PRIMARY KEY,personId int
,city varchar(50),state varchar(50));
insert into address 
values(1,1,"Chandigarh","Chandigarh"),
(2,2,"Winterfell","Game of thrones");
select p.FirstName,
p.LastName,
a.city,
a.state from person as p
left join address as a
on p.personId=a.personId;

