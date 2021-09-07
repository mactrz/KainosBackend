![Kainos logo](https://www.kainos.com/globalassets/images/5_logos/kainos_logo.png?mode=crop&width=200)
# Kainos Academy Project - Spring Backend App (Team E)

This is a backend application for our HR Management System project created during Kainos Engineering Academy.

## Requirements
- Java 16
- Maven 3.8
- MySQL 8.0.25

## Technology stack
- <img src='https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg' width="16"> Java
- <img src='https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg' width="16"> Spring
- <img src='https://editorconfig.org/logos/maven.png' width="16"> Maven
- <img src='https://junit.org/junit5/assets/img/junit5-logo.png' width="16"> JUnit 5
- <img src='https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original.svg' width="16"> MySQL

## Getting started
Make sure you have Java, Maven and MySQL installed and that MySQL server is running. 

```
java --version
mvn -v
mysql -u <username> -p <database-name>
```

Then, clone the source code repository and create a file called **application.properties** in the **src/main/resources** directory. There, you must provide necessary info and credentials for MySQL connection.

*Example application.properties file*
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://<host>/<db_name>
spring.datasource.username=myuser
spring.datasource.password=supersecretpassword123
spring.datasource.driver-class-name =com.mysql.jdbc.Driver
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.show-sql: true
backend.apikey=my_secure_api_key
```
Next, make sure you are in the root directory (the one with **pom.xml** file).
Here, you can find the database schema initialization scripts provided in **sql/** directory and run the application using commands shown below.

## Running the application

To start the backend app run `mvn spring-boot:run`.

To run unit tests use `mvn test`.