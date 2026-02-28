# 🏋️ Fitness Tracker Backend API

A secure and scalable RESTful backend built using **Spring Boot** that allows users to track workouts, manage fitness logs, and authenticate securely using JWT.

---

## 📌 Overview

The Fitness Tracker Backend provides:

- Secure User Registration & Login
- JWT-based Authentication
- Workout Tracking
- Calorie Management
- Role-based Authorization
- Exception Handling
- Clean Layered Architecture

This project is built following backend engineering best practices with scalability and security in mind.

---

## 🚀 Features

- ✅ User Registration
- ✅ User Login with JWT
- ✅ Secure Password Encryption (BCrypt)
- ✅ Add / View / Delete Workouts
- ✅ RESTful API Design
- ✅ Global Exception Handling
- ✅ Layered Architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack

- Java 25
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Hibernate / JPA
- MySQL 
- Maven 

---

## 🏗 Architecture

Layered Architecture:

Controller → Service → Repository → Database

Security Flow:

Client → JWT Filter → Authentication Manager → Security Context → Controller

This ensures:
- Separation of concerns
- Maintainability
- Scalability
- Secure stateless authentication

---

## 🔐 Authentication Flow (JWT)

1. User logs in with email & password
2. Credentials are authenticated
3. JWT token is generated
4. Client stores token
5. Client sends token in every request header

Header Format:

Authorization: Bearer <your_token>

Why JWT?
- Stateless authentication
- Scalable for distributed systems
- No session storage required

---

## 🗃 Database Schema

### Users Table

| Field      | Type   | Description         |
|------------|--------|--------------------|
| id         | Long   | Primary Key        |
| username   | String | Unique             |
| email      | String | Unique             |
| password   | String | Encrypted (BCrypt) |

### Workouts Table

| Field           | Type   | Description      |
|----------------|--------|-----------------|
| id             | Long   | Primary Key     |
| user_id        | Long   | Foreign Key     |
| workout_type   | String | Type of workout |
| duration       | Integer| Duration (mins) |
| caloriesBurned | Integer| Calories burned |

---

## 📡 API Endpoints

### 🔑 Authentication

| Method | Endpoint               | Description        |
|--------|------------------------|--------------------|
| POST   | /api/auth/register     | Register new user  |
| POST   | /api/auth/login        | Login user         |

---

## ⚙ Installation & Setup

### 1️⃣ Clone Repository

git clone https://github.com/yourusername/fitness-tracker-backend.git

cd fitness-tracker-backend

---

### 2️⃣ Configure Database

Update `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/fitness_tracker
spring.datasource.username=root
spring.datasource.password=yourpassword

---

### 3️⃣ Configure JWT

JWT_SECRET=your_secret_key
JWT_EXPIRATION=86400000

---

### 4️⃣ Run Application

If using Maven:

./mvnw spring-boot:run

If using Gradle:

./gradlew bootRun

Server runs at:

http://localhost:8080

---

## 🧪 Testing with Postman

1. Register a new user
2. Login to get JWT token
3. Add token in Authorization header
4. Access protected endpoints

---

## 📈 Scalability Considerations

- Uses HikariCP for connection pooling
- Stateless authentication using JWT
- Can be scaled horizontally using load balancer
- Easily containerized using Docker
- Can be migrated to microservices architecture

---

## 🔮 Future Improvements

- Pagination support
- Redis caching
- Dockerization
- CI/CD pipeline
- Role-based admin dashboard
- AI-based fitness recommendations
- Integration with wearable APIs

---

## 📁 Project Structure

src
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── security
 ├── exception
 └── config

---

## 👨‍💻 Author

Ritesh Thapliyal  
Backend Developer | Java | Spring Boot  

---

⭐ If you like this project, consider giving it a star!
