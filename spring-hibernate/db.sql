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







-----------------


create table employee (
id int(3) not null auto_increment,
name varchar(30),
salary decimal(8, 2),
department_id int(3) not null,
primary key (id),
foreign key (department_id) references department(id)
);

create table department(
id int(3) not null auto_increment,
name varchar(30),
primary key (id)
);


insert into department(name) values('sw');
insert into department(name) values('fin');

insert into employee(name, salary, department_id) values('se1', '1000.50', 1);
insert into employee(name, salary, department_id) values('se1', '1500.50', 1);
insert into employee(name, salary, department_id) values('sse1', '2000.50', 1);

insert into employee(name, salary, department_id) values('mkt1', '2001.00', 2);
insert into employee(name, salary, department_id) values('mkt2', '3001.00', 2);
insert into employee(name, salary, department_id) values('smkt1', '4001.00', 2);



select t.deptId, t.deptName, min(t.avgDeptSalary)
from (
select d.id as deptId, d.name as deptName, avg(e.salary) as avgDeptSalary
from department d
left join employee e on d.id = e.department_id
group by d.id
order by d.name
) t



select d.id as deptId, d.name as deptName, avg(e.salary) as avgDeptSalary
from department d
left join employee e on d.id = e.department_id
group by d.id
having avg(e.salary) > 1000
order by d.name