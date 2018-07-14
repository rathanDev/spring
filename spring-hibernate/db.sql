create database hibernate;

use hibernate;

create table employee (
 id int(3) unsigned not null auto_increment,
 name varchar(30),
 workplace int(3),
 primary key (id)
);