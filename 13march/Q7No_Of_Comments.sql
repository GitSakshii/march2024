 create table Submissions (
    sub_id int,
    parent_id int 
);
insert into Submissions (sub_id, parent_id) values
(1, NULL),
(2, NULL),
(1, NULL),
(12, NULL),
(3, 1),
(5, 2),
(3, 1),
(4, 1),
(9, 1),
(10, 2),
(6, 7);
select s_posts.sub_id as post_id,count(distinct s.sub_id) as number_of_comments
from Submissions s
right outer join
(select distinct sub_id from Submissions
where parent_id is null) as s_posts
on s.parent_id = s_posts.sub_id
group by post_id
order by post_id

