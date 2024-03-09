use sqlday2;
create table world(Name varchar(25),
Continent varchar(25),Area bigint,
population bigint,gdp bigint);

insert into world 
values ("Afghanistan", "Asia", 652230,25500100,20343000),
( "Albania", " Europe" ,28748 ,2831741 ,12960000 ),
( "Algeria" ,"Africa", 238174,37100000,188681000) ,  
("Andorra" , "Europe" ,468,78115 ,3712000 ),
( "Angola",  "Africa", 1246700 ,20609294, 100990000 );

Select Name ,population,Area from  world 
where Area>300000 OR population>2500000;
