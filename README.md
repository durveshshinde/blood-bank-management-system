# 🩸 Blood Donor Management System

## 📌 Project Overview

The **Blood Donor Management System** is a web-based application developed using **Java Servlets and JSP/HTML** that helps users find blood donors quickly during emergencies.

The system allows users to register as donors, search for available blood groups, and request blood, while the admin manages donor records and system data.

---

## 🎯 Problem Statement

In emergency situations, finding blood donors quickly is difficult due to:

* Lack of centralized data
* Time-consuming manual search
* No real-time availability tracking

This project provides a **simple and efficient digital solution** to manage and access donor information instantly.

---

## 🏗️ Project Structure

```
BloodDonorManagement/
│
├── src/
│   ├── servlets/              # All Servlet files (business logic)
│
├── webapp/
│   ├── html/                  # HTML pages (UI)
│   ├── css/                   # Styling files (or internal CSS)
│   ├── images/                # Images and assets
│   ├── jsp/ (optional)        # JSP pages (if used)
│
├── database/
│   └── blood_donor.sql        # Database schema
│
├── README.md
└── web.xml                    # Servlet configuration
```

---

## 👤 User Features

* 📝 Register as a blood donor
* 🔍 Search donors by blood group
* 📍 View donor details (name, contact, location)
* 🔐 Login and logout functionality
* 📩 Send blood request in emergency
* ✏️ Update profile information

---

## 🛠️ Admin Features

* 🔐 Secure admin login
* 📊 View all donor records
* ➕ Add new donors
* ✏️ Update donor details
* ❌ Delete donor records
* 📑 Manage blood requests

---

## ⚙️ Technology Stack

###  Frontend

* HTML5
* CSS3 (Internal & External)
* Basic JavaScript

###  Backend

* Java Servlets

###  Database

* MySQL

###  Server

* Apache Tomcat

###  Tools

* Eclipse IDE
* Git & GitHub

---

##  System Workflow

1. User registers as a donor
2. Data is stored in MySQL database
3. Other users can search donors by blood group
4. Admin manages and verifies donor data
5. Users can request blood during emergencies

---

##  How to Run the Project

1. Clone the repository
2. Open project in Eclipse
3. Configure Apache Tomcat Server
4. Import database using `blood_donor.sql`
5. Update database credentials in Servlet files
6. Run the project on server

---

##  Security Features

* Basic login authentication
* Session management using Servlets
* Input validation for forms

---

##  Key Highlights

* Simple and clean UI
* Fast donor search functionality
* Lightweight architecture (Servlet-based)
* Beginner-friendly and easy to understand

---

## Limitations

* No layered architecture (DAO/Service/Controller)
* Limited scalability
* Basic UI design


## Contribution

Contributions are welcome! Feel free to fork and improve the project.

---

## 📜 License

This project is open-source and available under the MIT License.

---
