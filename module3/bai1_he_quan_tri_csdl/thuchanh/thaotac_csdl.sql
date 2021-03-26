create database classic_models;

use classic_models;

create table customers (
	customer_number int primary key,
    customer_name varchar(50),
    contact_lastname varchar(50),
    contact_firstname varchar(50),
    phone varchar(50),
    address_line_1 varchar(50),
    address_line_2 varchar(50),
    city varchar(50)
);

insert into customers
values (1,'nguyen long phin','phin','nguyen','0778512349','hoa son hoa vang da nang',
'an ngai tay 3','da nang');

select * from customers;

update customers
set customer_name='nguyen van long'
where customer_number=1;