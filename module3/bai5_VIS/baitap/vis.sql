drop database if exists bai5;

create database bai5;

use bai5;

CREATE TABLE products (
    id INT PRIMARY KEY,
    `code` VARCHAR(10),
    `name` VARCHAR(45),
    price INT,
    amount INT,
    `description` VARCHAR(150),
    `status` VARCHAR(45)
);

create unique index index_code on products(`code`);

create index composite_index on products(`name`,price);

explain select * from products
where `code` = 'p1';

explain select * from products
where `name` = 'product1' and price = 1;

create view view_1 as
select `code`,`name`,price,`status`
from products;

select * from view_1;

delimiter //
create procedure my_procedure()
begin
select * from products;
end;
// delimiter ;

call my_procedure;

delimiter //
create procedure add_product()
begin
	insert into products
    values (1,'1','1',1,1,'1','1');
end;
// delimiter ;

call add_product;

delimiter //
create procedure update_product()
begin
	update products
    set `name` = 'edited'
    where id = 1;
end;
// delimiter ;

call update_product;

delimiter //
create procedure delete_product()
begin
	delete from products
    where id = 1;
end;
// delimiter ;

call delete_product;