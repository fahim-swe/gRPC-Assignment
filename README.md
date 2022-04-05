# gRPC-Assignment

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
