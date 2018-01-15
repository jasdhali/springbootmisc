/**
create table item (
	id Number(3) not null primary key,
	sku varchar2(50),
	reorderQuantity Number(3)
);

create table book(
      id Number(3) not null primary key,
      name varchar2(50) not null,
      author varchar2(50) not null,
      price Number(6,3));

create table account (
	id 			varchar2(20) not null primary key,
	password 	varchar2(20),
	username 	varchar2(20)
);
create table simple_user(
id int primary key, name varchar2(30)
);
*/