create database registerationdatabase;
use registerationdatabase;
create table Registeration(NAME varchar(30) not null, ROLLNO bigint, EMAIL_ID varchar(40),CONTACT_NO bigint, DOB varchar(20), 
         GENDER varchar(10), PASSWORD varchar(15), CONFIRM_PWD varchar(15));
         select *from Registeration; 
ALTER table Registeration ADD primary key(ROLLNO);

