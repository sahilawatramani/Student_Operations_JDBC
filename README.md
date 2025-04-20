# Student Data Entry System with MySQL (JDBC)

##  Description

This Java-based **Student Data Entry System** allows users to **Add, Search, Edit, Delete, and Display** student records using a **menu-driven interface**, while storing the data persistently in a **MySQL database** through **JDBC (Java Database Connectivity)**.  

It follows **Object-Oriented Programming (OOP)** principles and includes custom exception handling for robust error management.

---

##  Project Structure & Files

### 1️ Student.java  
Defines the **Student model class**, representing a student entity with proper field validation and encapsulation.

### 2️ StudentDAO.java  
Implements **data access methods** that interact with the MySQL database. Handles all database CRUD operations.

### 3️ DBConnection.java  
Provides a utility method to establish and return a **MySQL database connection** using JDBC.

### 4️ Main.java  
Contains the `main()` method with a **menu-driven console interface**, allowing users to interact with the system.

### 5️ customexceptions/**  
Package that contains various **custom exceptions** used throughout the application for validation and error handling.

---

##  Features / Functionalities

| Option | Feature |
|--------|---------|
| **1** | Add a new student (with validation). |
| **2** | Display all students from the database. |
| **3** | Search for a student (by PRN, Name, or Position). |
| **4** | Delete a student (by PRN). |
| **5** | Edit student details (Name, Age, CGPA) by PRN. |
| **6** | Exit the program. |

---

##  Methods Overview

### Student.java

| Method | Description |
|--------|-------------|
| Constructor | Initializes Student object with validation. |
| `setName()` / `getName()` | Setter and getter for Name. |
| `setPrn()` / `getPrn()` | Setter and getter for PRN. |
| `setAge()` / `getAge()` | Setter and getter for Age. |
| `setCgpa()` / `getCgpa()` | Setter and getter for CGPA. |
| `display()` | Prints student details. |

---

### StudentDAO.java (Handles Database Operations)

| Method | Description |
|--------|-------------|
| `addStudent(Student student)` | Inserts a student into the database. |
| `displayStudents()` | Retrieves and displays all students. |
| `searchStudent()` | Search student by PRN, Name, or Row Number. |
| `deleteStudent()` | Deletes a student by PRN. |
| `editStudent()` | Updates a student’s details. |

---

### DBConnection.java

| Method | Description |
|--------|-------------|
| `getConnection()` | Returns a JDBC connection object to the MySQL database. |

---

##  Custom Exceptions

- `InvalidNameException`, `InvalidPRNException`, `InvalidAgeException`, `InvalidCGPAException`
- `EmptyStudentListException`, `StudentNotFoundException`, `DuplicatePRNException`
- `TooManyStudentsException`, `InvalidMenuChoiceException`, `InvalidSearchChoiceException`
- `EditNotAllowedException`, `InvalidPositionException`, `NegativeValueException`, `EmptyNameException`, `NullStudentException`, `DeletionNotAllowedException`

Each exception represents a specific validation or logical failure, making the system more reliable and maintainable.

---

##  How to Run the Program

###  Prerequisites:
- Java JDK installed
- MySQL server installed and running
- A MySQL database and `students` table created
- JDBC driver (e.g., `mysql-connector-j-8.x.x.jar`) added to classpath

###  Step-by-Step Instructions

1. **Create Database and Table in MySQL:**

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    prn BIGINT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    cgpa DOUBLE
);
