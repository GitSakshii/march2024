create table Products (
    product_id INT PRIMARY KEY,
    low_fats ENUM('Y', 'N'),
    recyclable ENUM('Y', 'N')
);

insert into Products (product_id, low_fats, recyclable) 
values
    (0, 'Y', 'N'),
    (1, 'Y', 'Y'),
    (2, 'N', 'Y'),
    (3, 'Y', 'Y'),
    (4, 'N', 'N');
-- Selects the Products which are both low fat and recyclable    
select  product_id 
from products
where low_fats= 'Y'And recyclable ='Y';
   