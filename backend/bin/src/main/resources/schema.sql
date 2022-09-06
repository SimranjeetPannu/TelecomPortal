drop database if exists telecomproject ;
create database telecomproject;
use telecomproject;
create table users(
	id int auto_increment,
    username varchar(50),
    email varchar(50),
    password varchar(100),
    primary key (id)
);

create table plans(
	id int auto_increment primary key,
    customerid int,
    planname varchar(30),
    plancost int,
    devicelimit int,
	user_id int,
    foreign key (user_id) references users(id)
    on delete cascade
);

create table devices(
	id int auto_increment primary key,
    devicename varchar(45),
    phonenumber varchar(15) unique,
    planid int,
    foreign key (plan_id) references plans(id)
    on delete cascade
);

insert into users(username, email, password)
values("nhaleem", "nhaleem@gmail.com", "$2a$12$SFn6/uZPB/RHnYg16VZSfeUXR0.jlEhTIYOXHzukRAaYWUYQpK9OC");

insert into users(username, email, password)
values("spannu", "spannu@gmail.com", "$2a$12$CJjQ0hKUaYN6iIZILFLo6.hUjk3caLPcwvSobtBjEUvJnLD4ohxhe" );

insert into users(user_name, email, pass_key)
values("chart", "chart@gmail.com", "$2a$12$HVPAyTsAEIUPppUk9MFbbO/oqScY/GFYTBc21UcfjX7ML0Zp5nmiS");

insert into plans(planname, devicelimit, customerid, plancost)
values("Yellow Plan", 1, 1, 31.45);

insert into plans(planname, devicelimit, customerid, plancost)
values("Blue Plan", 4, 2, 65.76);

insert into plans(planname, devicelimit, customerid, plancost)
values("Green Plan", 9, 3, 124.36);

insert into devices(devicename, planid, phonenumber)
values("iPhone12", 1, "6548521451");

insert into devices(devicename, planid, phonenumber)
values("Google6", 2, "8475217489");

insert into devices(devicename, planid, phonenumber)
values("iPhone11", 3, "1245874869");
