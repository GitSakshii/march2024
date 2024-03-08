create table playback(
session_id int  PRIMARY KEY,
customer_id int,
start_time int,
end_time int,
CONSTRAINT check_start_and_end_time CHECK(start_time <= end_time));
INSERT INTO playback
values(1, 1, 1, 5),
(2, 1, 15, 23),
(3, 2, 10, 12),
(4, 2, 17, 28),
(5, 2, 2, 8);

create table ads( ad_id int PRIMARY KEY ,
customer_id  int,
 timestamp  int );
 insert into ads
 values(1,1,5),(2,2,17),(3,2,20);
select session_id FROM playback p
LEFT JOIN ads a
ON p.customer_id=a.customer_id
AND a.timestamp BETWEEN p.start_time AND p.end_time
where a.customer_id IS NULL
