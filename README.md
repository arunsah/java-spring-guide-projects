# java-spring-guide-projects
Implementation of tutorial from https://spring.io/guides
---
---

### Building a RESTful Web Service ###
https://spring.io/guides/gs/rest-service/


#### Consuming a RESTful Web Service with jQuery ####
https://spring.io/guides/gs/consuming-rest-jquery/

http://localhost:9001/greeting?name=Arun

#### Enabling Cross Origin Requests for a RESTful Web Service ####
https://spring.io/guides/gs/rest-service-cors/
---

### Consuming a RESTful Web Service ###
https://spring.io/guides/gs/consuming-rest/
---

### Securing a Web Application ###
https://spring.io/guides/gs/securing-web/

https://stackoverflow.com/questions/36697663/circular-view-path-error-spring-boot/41918545

#### Uploading Files ####
https://spring.io/guides/gs/uploading-files/

Build success

#### Securing using: ####
##### Spring Boot Security - Password Encoding Using BCrypt #####
 https://www.javainuse.com/spring/boot_security_jdbc_authentication_bcrypt

- create table:

```sql
create table if not exists user_security(
	id int not null auto_increment primary key,
	username varchar(100),
	password varchar(255),
	email varchar(255) default null,
	active varchar(10) default 'YES',
	role varchar(50) default 'USER',
	created datetime default NOW()
);
```

- table structure:

```
mysql> desc user_security;
+----------+--------------+------+-----+-------------------+-------------------+
| Field    | Type         | Null | Key | Default           | Extra             |
+----------+--------------+------+-----+-------------------+-------------------+
| id       | int(11)      | NO   | PRI | NULL              | auto_increment    |
| username | varchar(100) | YES  |     | NULL              |                   |
| password | varchar(255) | YES  |     | NULL              |                   |
| email    | varchar(255) | YES  |     | NULL              |                   |
| active   | varchar(10)  | YES  |     | YES               |                   |
| role     | varchar(50)  | YES  |     | USER              |                   |
| created  | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+----------+--------------+------+-----+-------------------+-------------------+
7 rows in set (0.00 sec)
```

- inserting data:

```
insert into user_security (username, password) values('tom', 'tomtom');


```

#### Spring Boot Security REST + JPA + Hibernate + MySQL CRUD Example ####
https://www.concretepage.com/spring-boot/spring-boot-security-rest-jpa-hibernate-mysql-crud-example


#### Scheduling Tasks ####
https://spring.io/guides/gs/scheduling-tasks/

https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html

---
### Accessing data with MySQL ###
https://spring.io/guides/gs/accessing-data-mysql/




