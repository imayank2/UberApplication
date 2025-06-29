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
