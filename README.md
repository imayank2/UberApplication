# 🚖 Cab Booking System (Uber Clone)

A backend system for booking cabs, matching drivers, and calculating fares in real-time. This project is inspired by ride-sharing apps like Uber and focuses on backend functionality with modern technologies.

## 🧠 Features

- 🔒 **JWT Authentication** – Secure login and token-based access control for both users and drivers.
- 📍 **Real-time Location Tracking** – PostGIS used to store and track driver and user locations with high accuracy.
- 💸 **Dynamic Fare Calculation** – Fares are calculated using the **OSMR API** based on:
  - Travel distance
  - Driver rating
  - Surge pricing (if any)
- 🤝 **Driver Matching System** – Matches available drivers within a certain radius using spatial queries.
- 📧 **Email Notifications** – SMTP integration for alerts and communication (booking confirmations, etc.)

---

## 🛠️ Technologies Used

- **Backend**: Spring Boot, Spring Data JPA  
- **Database**: PostgreSQL with PostGIS (for geolocation data)  
- **Authentication**: JWT (JSON Web Token)  
- **APIs**: OSMR (Open Source Routing Machine), RESTful APIs  
- **Email Service**: JavaMailSender with SMTP

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/imayank2/UberApplication.git
cd UberApplication
```
### 2. Configure application.properties
Create and update src/main/resources/application.properties:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/uberdb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

jwt.secret=your_jwt_secret
spring.mail.username=your_email@gmail.com
spring.mail.password=your_email_password
```
### 3. Build & Run
```bash
./mvnw clean install
./mvnw spring-boot:run
```
🔄 API Endpoints (Sample)
Authentication
POST /api/auth/signup

POST /api/auth/login

Booking
POST /api/book – Book a ride

GET /api/book/status/{id} – Check ride status

Drivers
POST /api/driver/update-location

POST /api/driver/accept/{rideId}

POST /api/driver/reject/{rideId}

📌 Database Schema (Simplified)
User – id, name, email, password, role

Driver – id, name, rating, location (PostGIS Point)

Ride – id, user_id, driver_id, source, destination, fare, status

📬 Contact
Feel free to reach out if you need help or want to contribute!

👤 Author: Mayank Chauhan

📧 Email: mayankchauhan8515@gmail.com

## 🧠 System Design (Low-Level Design)

This diagram shows how different parts of the cab booking system work together, like rider, driver, payment, and ride manager.

🔗 **View Online**: [Cab Booking System – Whimsical](https://whimsical.com/cab-booking-system-Q5MoxceAmRWMVtELBzCb8e)

🖼️ **Diagram**:

![Uber LLD Diagram](0ee7431d-bb00-4d9b-a029-dc2f3ba7f2b9.png)



