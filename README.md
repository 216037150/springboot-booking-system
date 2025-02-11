# Spring Boot Appointment Booking System

## Overview
This is an **appointment booking system** where **patients** can book appointments with doctors, and **admins** can accept or reject these appointments. The system uses **Spring Boot** for the backend and **Angular** for the frontend.

## Features
- Patients can **book** appointments.
- Admins can **accept** or **reject** appointments.
- Appointment statuses: **PENDING, ACCEPTED, COMPLETED, CANCELED**.
- Patients can **cancel** their appointments.
- REST API endpoints for managing appointments.

## Tech Stack
### Backend:
- **Spring Boot** (Java)
- **Spring Data JPA**
- **PostgreSQL** (or MySQL)
- **Spring Boot Security (optional for authentication)**

### Frontend:
- **Angular** (for UI development)
- **Bootstrap/TailwindCSS** (for styling)

## Installation & Setup

### Prerequisites
- **Java 17+** (JDK)
- **Spring Boot**
- **PostgreSQL** (or MySQL)
- **Node.js** (for Angular frontend)

### Backend Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/springboot-booking-system.git
   cd springboot-booking-system
   ```
2. **Configure the database** in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
3. **Run the Spring Boot application:**
   ```sh
   mvn spring-boot:run
   ```

### Frontend Setup
1. **Navigate to the Angular project folder:**
   ```sh
   cd frontend
   ```
2. **Install dependencies:**
   ```sh
   npm install
   ```
3. **Run the Angular application:**
   ```sh
   ng serve
   ```

## API Endpoints

### **Appointments**
| Method | Endpoint               | Description |
|--------|------------------------|-------------|
| GET    | `/appointments`         | Get all appointments |
| POST   | `/appointments/book`    | Book an appointment |
| PUT    | `/appointments/{id}/accept` | Accept an appointment |
| PUT    | `/appointments/{id}/complete` | Mark appointment as completed |
| PUT    | `/appointments/{id}/cancel` | Cancel an appointment |

## Future Enhancements
- User authentication (Spring Security & JWT)
- Email notifications for appointment status updates
- Calendar integration

## License
This project is **open-source** under the **MIT License**.

