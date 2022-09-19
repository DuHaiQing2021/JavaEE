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
--给博客表插入数据方便测试
insert into blog value(null,"这是第一篇博客","从今天起,开始认真学Java",1,now());
insert into blog value(null,"这是第二篇博客","从昨天起,开始认真学Java",1,now());
insert into blog value(null,"这是第三篇博客","从前天起,开始认真学Java",1,now());
insert into blog value(null,"这是第一篇博客","从今天起,开始认真学Java",4,now());
insert into blog value(null,'这是第二篇博客','#一级标题\n###三级标题\n>这是引用内容',2,now());


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
