create table views(article_id int,
 author_id int ,
 viewer_id int ,
view_date date );
 
 
 insert into views 
 values
 (1,3,5,'2019-08-01'),
 (3,4,5,'2019-08-01'),
 (1,3,6,'2019-08-02'),
 (2,7,7,'2019-08-01'),
 (2,7,6,'2019-08-02'),
 (4,7,1,'2019-07-22'),
 (3,4,4,'2019-07-21'),
 (3,4,4,'2019-07-21');
SELECT  viewer_id as id
FROM views
GROUP BY view_date, viewer_id
HAVING COUNT(Distinct(author_id)) > 1
order by id;

 