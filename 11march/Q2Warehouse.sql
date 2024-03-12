create table warehouse(Name varchar(25),
Product_id int , units int,
PRIMARY KEY (Name,Product_id)
);
create table Products(
product_id  int , product_name varchar(25),
 Width int, Length int,
 Height int );
insert into warehouse
values
('LCHouse1',1, 1 ),
('LCHouse1',2,10),
('LCHouse1',3,5),
('LCHouse2',1,2),
('LCHouse2',2,2),
('LCHouse3',4,1);
insert into Products
values (1,'LC-TV' ,5 ,50,40),
(2,'LC-KeyChain', 5,5,5),
(3,'LC-Phone',2,10,10),
(4,'LC-T-Shirt', 4,10, 20 );

SELECT 
    w.Name AS warehouse_name,
    SUM(p.Width * p.Length * p.Height * w.units) AS volume
FROM 
    warehouse w
JOIN 
    Products p ON w.product_id = p.product_id
GROUP BY
    w.Name;

drop table Products;
