drop database if exists  quan_ly_sieu_thi ;

create database quan_ly_sieu_thi ;

use  quan_ly_sieu_thi ;

create table custommer(
cid int primary key,
cname varchar(50),
cage varchar(50)
);
create table product (
pid int primary key,
pname varchar(50),
pprice varchar(50)
);

create table `order`(
oid int primary key,
cid int ,
odate varchar(50),
ototalprice varchar(50),
foreign key (cid) references custommer(cid)

);

create table order_detail (
oid int,
pid int,
odqty varchar(50),
primary key (pid,oid) ,
foreign key (oid) references `order`(oid),
foreign key (pid) references `product`(pid)
);
