drop database if exists bai3;

create database bai3;

use bai3;

create table image (
	id int primary key,
    url text
);

create table student (
	student_number varchar(15) primary key,
    student_name varchar(50) unique, 
    email varchar(50) unique,
    image_id int,
    foreign key (image_id) references image(id)
);

create table address (
	id int primary key,
    state varchar(50),
    city varchar(50),
    country varchar(50)
);

create table address_student (
	address_id int,
    student_number varchar(15),
    primary key(address_id,student_number),
    foreign key (address_id) references address(id),
    foreign key (student_number) references student(student_number)
);

create table type_of_book (
	id int primary key,
    `name` varchar(50)
);

create table book (
	book_number varchar(15) primary key,
    book_name varchar(50) unique,
    producer varchar(50),
    author varchar(50),
    product_year date,
    product_time int,
    price double,
    image_id int,
    type_id int,
    foreign key (type_id) references type_of_book(id),
    foreign key (image_id) references image(id)
);

create table book_card (
	card_number varchar(15) primary key,
    student_number varchar(15),
    foreign key (student_number) references student(student_number)
);

create table booking_history (
	book_card_number varchar(15),
    book_number varchar(15),
    date_start date,
    date_end date,
    primary key(book_card_number,book_number),
    foreign key (book_card_number) references book_card(card_number),
    foreign key (book_number) references book(book_number)
);


