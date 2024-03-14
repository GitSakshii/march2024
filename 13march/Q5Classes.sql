create table courses (
    student VARCHAR(50),
    class VARCHAR(50)
);

insert into courses (student, class) values
('A', 'Math'),
('B', 'English'),
('C', 'Math'),
('D', 'Biology'),
('E', 'Math'),
('F', 'Computer'),
('G', 'Math'),
('H', 'Math'),
('I', 'Math');

select class from courses 
group by class having count(class)>5;