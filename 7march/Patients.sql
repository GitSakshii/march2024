create table patients
(patient_id  int PRIMARY KEY ,
 patient_name varchar(45),
 conditions varchar(45));
 insert into patients
 values (1 ,"Daniel" ,"YFEV COUGH"),
( 2,"Alice","" ),
(3," Bob","DIAB100 MYOP"),
(4,"George" ,"ACNE DIAB100"),
(5,"Alain","DIAB201 ");
select * from patients where conditions like '%DIAB1%';