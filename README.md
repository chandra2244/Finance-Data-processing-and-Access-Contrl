# Finance Dashboard Backend

## Overview

This project is a backend system for managing financial records and generating dashboard insights.
It allows users to perform CRUD operations on financial data and provides summary analytics.

---

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* MySQL

---

## Project Structure

The application follows a layered architecture:

* Controller → Handles API requests
* Service → Contains business logic
* Repository → Handles database operations
* Entity → Represents database tables

---

##  User Roles

| Role    | Access                               |
| ------- | ------------------------------------ |
| VIEWER  | Can only view records                |
| ANALYST | Can view and update records          |
| ADMIN   | Full access (create, update, delete) |

Role is passed via request header:

```
role : ADMIN
```

---

## Features

* Create financial records
* View all records
* Update records
* Delete records
* Dashboard summary (income, expense, balance)
* Role-based access control
* Input validation

---

## 🔗 API Endpoints

### ➤ Create Record

POST /records

Request Body:

```json
{
  "amount": 5000,
  "type": "income",
  "category": "salary",
  "date": "2026-04-01",
  "note": "April salary"
}
```

---

###  Get All Records

GET /records

---

###  Update Record

PUT /records/{id}

---

### Delete Record

DELETE /records/{id}

---

### Dashboard Summary

GET /dashboard/summary

Response:

```json
{
  "income": 10000,
  "expense": 3000,
  "balance": 7000
}
```

---

## Validation & Error Handling

* Amount must be greater than 0
* Invalid requests return error messages
* Role-based access restrictions applied

---

## Database

Database used: MySQL

Example table:

* FinancialRecord

  * id
  * amount
  * type
  * category
  * date
  * note

---

## Assumptions

* Role is passed via request header
* Authentication is simplified (no login system)
* Data stored in MySQL

---

## How to Run

1. Start MySQL and create database:

   ```sql
   CREATE DATABASE finance_db;
   ```

2. Update application.properties:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
   spring.datasource.username=root
   spring.datasource.password=root
   ```

3. Run Spring Boot application

4. Test APIs using Postman

---

## Conclusion

This project demonstrates backend development skills including API design, data handling, role-based access control, and clean architecture.
