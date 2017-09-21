
create table book(
      id int not null primary key,
      name varchar_ignorecase(50) not null,
      author varchar_ignorecase(50) not null,
      price int);

#create table item (
#	itemId int not null primary key,
#	itemSku varchar_ignorecase(50),
#	reorderQuantity varchar_ignorecase(50)
#);

create table account (
	id varchar_ignorecase(20) not null primary key,
	password varchar_ignorecase(20),
	username varchar_ignorecase(20)
);