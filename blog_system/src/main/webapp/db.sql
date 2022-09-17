--编写建库建表的sql
create database if not exists BlogSystem;

use BlogSystem;

--创建一个博客表
drop table if exists blog;
create table blog(
    blogId int primary key auto_increment,
    title varchar(1024),
    content mediumtext,
    userId int,
    postTime datetime
);

--创建一个用户表
drop table if exists user;
create table user(
    userId int primary key auto_increment,
    username varchar(128) unique,
    password varchar(128)
);
insert into user value(null,"张三","123456");
insert into user value(null,"李四","123456");
insert into user value(null,"王五","123456");
insert into user value(null,"杜海庆","123456");
