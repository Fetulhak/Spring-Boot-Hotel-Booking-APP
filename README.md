# Hotel Booking System - Spring Boot Application

This project is a Hotel Booking System built using **Spring Boot**, **Spring Security**, and **JWT** for secure user authentication. It allows users to manage hotel room bookings, user roles (ADMIN and USER), and perform CRUD operations on bookings and users. The system supports JWT-based stateless authentication and authorization, ensuring that only authorized users can perform specific actions.

## Project Structure


## Features

- **User Authentication & Authorization**: Users can register and authenticate using JWT. Roles (Admin, User) are assigned, and role-based access is implemented.
- **Booking Management**: Users can book rooms, view bookings, and manage their booking details.
- **Room Management**: Admin users can manage rooms and view the list of all bookings.
- **JWT Authentication**: Secure login with JWT-based stateless authentication.
- **Role-Based Access Control**: Admin and user roles with permissions to perform actions based on their roles.

## Requirements

- **Java 17 or later**
- **Spring Boot 3.x**
- **MySQL Database** (or any relational database)
- **Maven** for dependency management

## Setup and Installation

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/hotel-booking-system.git
cd hotel-booking-system


### 2. Setup MySQL Database

Create a MySQL database named hotel_db and configure the database connection in src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=fetu
spring.datasource.password=Emamudin7013@
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect



- **JWT**: For secure token-based authentication.
- **MySQL**: For data storage.
- **BCryptPasswordEncoder**: For password encryption.
- **Lombok**: For boilerplate code reduction (Getters, Setters, Constructors).
