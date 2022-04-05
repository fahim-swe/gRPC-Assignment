# gRPC-Assignment

# Overview of the services:

A user service that takes  a username as an input and the service will try to retrieve the user details (User ID, Username, Name, Age, and Gender).
# Steps to Build User Service
1) create a gRPC project with maven and add all necessary dependencies
2) Define a user.proto and generate stubs
3) Set up database connection code and the database script
4) Add a useDao class with a method to get user details from database
5) write a userServiceImple class that implements the services stub and connect it with the UserDao class

# Database Setup Details
	
1) H2 database
2) Tables used- User: contains user details
3) Initialize.sql file will create tables and prepare all data


Ref: https://www.linkedin.com/learning/building-java-microservices-with-grpc
https://dzone.com/articles/building-microservices-with-grpc-and-java
https://medium.com/geekculture/how-to-create-grpc-microservices-with-jpa-b3e804b4d91e
