Reference:
Designing Microservices using Spring Boot, Spring Cloud, Eureka and Zuul | # 1 | Tech Primers
https://www.youtube.com/watch?v=rlS9eH5tEnY&t=899s

start.spring.io
db-service Dependencies: mysql, web, jpa
stock-service   Dependencies: web, Eureka Discovery

#Mysql
select Host, User from mysql.user;

CREATE USER 'testuser'@'%' IDENTIFIED BY 'Test@123';
GRANT ALL PRIVILEGES ON test.* TO 'testuser'@'%' IDENTIFIED BY 'Test@123'; 


#Challenge

No such method error
when using 2.0.4 of spring boot parent
because of mixed up dependencies
use start.spring.io, properly generate the project

com.netflix.discovery.shared.transport.TransportException: Cannot execute request on any known server
