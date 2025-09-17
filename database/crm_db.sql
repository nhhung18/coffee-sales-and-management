create database crm_db;
use crm_db

create table `user` (
	id int unsigned auto_increment primary key,
    user_name varchar(30) not null unique key,
    full_name nvarchar(100) not null,
    gender enum('MALE','FEMALE','OTHER'),
    birth_day date,
    phone varchar(15) not null unique key,
	email varchar(255) not null unique key,
    avatar varchar(255),
    `password` varchar(255) not null,
    createAt datetime,
    updateAt datetime,
    `status` enum('VERIFY','ACTIVE','BLOCKED')
)