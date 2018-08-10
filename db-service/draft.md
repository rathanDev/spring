Reference:
Designing Microservices using Spring Boot, Spring Cloud, Eureka and Zuul | # 1 | Tech Primers
https://www.youtube.com/watch?v=rlS9eH5tEnY&t=899s

start.spring.io
Dependencies: mysql, web, jpa


#Mysql
select Host, User from mysql.user;

CREATE USER 'testuser'@'%' IDENTIFIED BY 'Test@123';
GRANT ALL PRIVILEGES ON test.* TO 'testuser'@'%' IDENTIFIED BY 'Test@123'; 



#http
#POST http://localhost:8300/rest/db/add
POST http://localhost:8300/rest/db/delete/jana
Accept: */*
Content-Type: application/json

#{
#  "username": "rathan",
#  "quotes": ["Train insane or remain same",
#    "Feel the power of silence"]
#}

#{
#  "username": "jana",
#  "quotes": ["Be the change, that you wish to see in this world",
#    "No one can make you feel inferior without your consent"]
#}