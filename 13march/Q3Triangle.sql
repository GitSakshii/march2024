create table sides(x int ,y int ,z int);
insert into sides values(13,15,30),(10,20,15);
-- gives a table rep
select x,y,z,
 case 
 when x+y>z and y+z>x and x+z>y then 'Yes'
 else 'No'
 end as Triangle
 from sides;