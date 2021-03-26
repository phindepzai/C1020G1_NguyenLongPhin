drop database if exists bai3;

create database bai3;

use bai3;

create table customers (
	customer_number int primary key,
    fullname varchar(45),
    address varchar(45),
    email varchar(45) unique,
    phone varchar(10) unique
);

create table account_type (
	id int primary key,
    name varchar(45)
);

create table accounts (
	account_number int primary key,
    account_type_id int,
    `date` date,
    balance int,
    foreign key (account_type_id) references account_type(id)
);

create table transactions (
	tran_number int primary key,
    account_number int,
    `date` date,
    amounts int,
    `description` varchar(45),
    foreign key (account_number) references accounts(account_number)
);