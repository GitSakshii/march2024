-- Report Provinding the details of customer ids of all the custormers that bought all the products 
-- available in product table
create table Product (
    product_key INT PRIMARY KEY
);
create table Customer(
customer_id int, 
product_key int
);


insert into customer values(1,5),(2,6),(3,5),(3,6),(1,6);
insert into Product (product_key) 
values(5),(6);
select customer_id 
from customer 
group by Customer_id
having count(distinct(product_key))=(select count(*) from product);
