# RESTful-SpringBoot Web Service Example

The main purpose of this sample project is to demonstrate the capabilities of spring boot and how it is easy to start a web service with embedded tomcat. This is a sample Java / Maven / Spring Boot / RESTful Web Service application that can be used as a starter for creating a microservice with REST calls GET and POST.

## Description about application

In this application there is two end points are created, student data registration and student data receiver for register and fetch student’s information. Through this you can register number of students into application and find a particular student or many students as per requirement.

## How to Run
To use this project, you are going to need:
* Java JDK 8 (1.8)
* Maven compatibile with JDK 8
*	Any Java IDE
*	Postman tool

We are going to build a demo app named as RESTful-Spring Boot. This will be a simple web service with create and read operations. I'm going to demonstrate default and external configuration, how to use multiple implementation and autowire them within the code. Our app will be a standalone application that we can use independently, and we are going to use an embedded tomcat.

## Spring Boot Dependencies
For this Spring Boot project add dependencies just as below in POM.xml file of project. 
```
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
```
And we'll also add the below information for the property file for this project under the build section of our POM.xml file (to change the port number at the moment):
        <resource>
            <directory>src/main/resources</directory>
            <filtering>true</filtering>
        </resource>



## Add Application Properties

Now open file application.properties  and add the below lines in it:

spring.profiles.active=@spring.profiles.active@

## Sending And Receiving JSONs With Postman

In this part, I'm going to demonstrate all operations defined in our StudentRegistrationController class and StudentRetrieveController how to test them either with our web browser or with the Postman tool. 

We can test our GET methods with any web browser but for operations that use HTTP POST methods, we cannot execute them with a simple web browser, so I'm going to use Postman tool for that. I've provided create and read operations within postman, so that you can load all the prepared operations in Postman tool.

**Register student** 
```
Sub Path: / register/student
Full URL: http://localhost:8080/register/student
Method:   POST
Sends:    JSON
Receives: JSON


Sample Input;
{
    "name":"jigga",
    "age":24,
    "registrationNumber":"4488"
}

Sample Output;
{
    "name": "jigga",
    "age": 24,
    "registrationNumber": "4488",
    "registrationStatus": "Successful"
}
```

**Retrieve list of students**
```
Sub Path: /student/allstudent
Full URL: http://localhost:8080/student/allstudent
Method:   GET
Sends:    N/A
Receives: JSON
Sample Input: N/A
Sample Output;
{
        "name": "jigga",
        "age": 24,
        "registrationNumber": "4488"
}
```

