use avisoft;
create table Product(
product_id int,
low_fats enum('Y','N'),
recyclable enum('Y','N'));

insert into Product 
values(0,'Y','N'),(1,'Y','Y'),(2,'N','Y'),(3,'Y','Y'),(4,'N','N');
select * from Product;

select product_id from Product
where low_fats='Y' AND recyclable='Y';