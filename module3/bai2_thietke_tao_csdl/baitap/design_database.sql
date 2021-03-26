drop database if exists bai3;

create database bai3;

use bai3;

create table product_lines (
	product_line varchar(50) primary key,
    text_description text,
    html_description text,
    image varchar(50)
);

create table offices (
	office_code varchar(10) primary key,
    city varchar(50) not null,
    phone varchar(50) not null,
    address_line1 varchar(50) not null,
    address_line2 varchar(50),
    state varchar(50),
    country varchar(50) not null,
    postal_code varchar(15) not null,
    territory varchar(10) not null
);

create table employees (
	employee_number int primary key,
    lastname varchar(50) not null,
    firstname varchar(50) not null,
    email varchar(100) not null,
    job_title varchar(50) not null,
    office_code varchar(10),
    foreign key (office_code) references offices(office_code)
);

create table customers (
	customer_number int primary key,
    customer_name varchar(50) not null,
    contact_lastname varchar(50) not null,
    contact_firstname varchar(50) not null,
    phone varchar(50) not null,
    address_line1 varchar(50) not null,
    address_line2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postal_code varchar(15) not null,
    country varchar(50) not null,
    sales_rep_employee_number int,
	credit double,
    foreign key (sales_rep_employee_number) references employees(employee_number)
);

create table products (
	product_code varchar(15) primary key,
    product_name varchar(70) not null,
    product_scale varchar(10) not null,
    product_vendor varchar(50) not null,
    product_line varchar(50),
    product_description text not null,
    quantity_in_stock int not null,
    buy_price double not null,
    msrp double not null,
    foreign key (product_line) references product_lines(product_line)
);

create table payments (
	customer_number int,
    check_number varchar(50) not null,
	payment_date date not null,
    amount double not null,
    foreign key (customer_number) references customers(customer_number)
);

create table orders (
	order_number int primary key,
    customer_number int,
    order_date date not null,
    required_date date not null,
    shipped_date date not null,
    `status` varchar(15) not null,
    comments text,
    foreign key (customer_number) references customers(customer_number)
);

create table order_detail (
	order_number int,
    product_code varchar(15),
    quantity_ordered int not null,
    price_each double,
    order_line_number int not null,
    foreign key (order_number) references orders(order_number),
    foreign key (product_code) references products(product_code)
);