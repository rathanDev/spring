create database hibernate;

use hibernate;

create table employee (
 id int(3) unsigned not null auto_increment primary key,
 name varchar(30),
 workplace int(3)
);

create table workplace (
  id int(3) unsigned not null auto_increment primary key,
  name varchar(30)
);
-- drop table workplace;