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
```

### 2. Setup MySQL Database

Create a MySQL database named hotel_db and configure the database connection in src/main/resources/application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=fetu
spring.datasource.password=Emamudin7013@
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```


### 3. Install Dependencies
Use Maven to install the necessary dependencies.

### 4. Run the Application
You can run the application using Maven:



## API Endpoints

Here’s a quick overview of some of the key API endpoints.

### **Public Endpoints**
- **POST /auth/login**: User login, returns a JWT token.

### **Secured Endpoints**
- **GET /users/all**: Get all users (Admin only).
- **GET /users/{email}**: Get user details by email (Admin or User).
- **DELETE /users/delete/{email}**: Delete a user by email (Admin or the user themselves).
- **POST /rooms**: Admin adds a new room.
- **GET /rooms**: Get all rooms (Admin).
- **POST /bookings**: Create a new booking.
- **GET /bookings**: Get all bookings (Admin).
- **GET /bookings/{email}**: Get bookings by user email (Admin or the user themselves).

### **Authorization**
- **Admin Role** (`ROLE_ADMIN`) has access to all endpoints except those related to user login.
- **User Role** (`ROLE_USER`) has access to their own bookings and can delete their own account.

### **Security**
This application uses **Spring Security** to secure the endpoints with JWT authentication. The JWT token is passed in the `Authorization` header as `Bearer <token>`. The token is valid for 15 minutes and should be refreshed for continued access.

## Database Structure

The project uses the following entities:

- **User**: Represents a user in the system, associated with roles (Admin, User).
- **Role**: Represents user roles that grant specific permissions.
- **Room**: Represents hotel rooms, which can be booked by users.
- **BookedRoom**: Represents a booking, including check-in, check-out dates, and guest details.

## Technologies Used

- **Spring Boot**: For backend development.
- **Spring Security**: For handling authentication and authorization.
- **JWT**: For secure token-based authentication.
- **MySQL**: For data storage.
- **BCryptPasswordEncoder**: For password encryption.
- **Lombok**: For boilerplate code reduction (Getters, Setters, Constructors).

