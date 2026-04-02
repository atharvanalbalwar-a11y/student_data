# 🎓 Student Management System

A console-based Java application that manages students, professors, and admins using a **MySQL database**. Users can register, log in, and perform role-specific operations like course registration, syllabus management, and complaint handling.

---

## 📁 Project Structure

```
student_data/
│
├── assignment1.java    # Main entry point — registration & login flow
├── database.java       # MySQL database handler (all CRUD operations)
├── student.java        # Student role logic
├── professor.java      # Professor role logic
└── admin.java          # Admin role logic
```

---

## ✨ Features by Role

### 👨‍🎓 Student
- Register with name and password
- Login with ID and password
- Submit a complaint
- View available courses
- Register for a course
- View profile information

### 👩‍🏫 Professor
- Register with name and password
- Login with ID and password
- View assigned syllabus
- Update syllabus
- View profile information

### 🛡️ Admin
- Register with name and password
- Login with ID and password
- Add new courses (ID, name, credits)
- View all student complaints
- Delete a student record
- View profile information

---

## 🗄️ Database Schema

The app connects to a **MySQL** database named `studentmanagementdb`.

| Table       | Columns                                           |
|-------------|---------------------------------------------------|
| `students`  | `ID`, `NAME`, `passwords`, `Courses`, `Complaint` |
| `professor` | `ID`, `NAME`, `passwords`, `Syllabus`             |
| `admins`    | `ID`, `NAME`, `passwords`                         |
| `courses`   | `ID`, `Name`, `Credits`                           |

### MySQL Setup

```sql
CREATE DATABASE studentmanagementdb;

USE studentmanagementdb;

CREATE TABLE students (
    ID INT PRIMARY KEY,
    NAME VARCHAR(100),
    passwords VARCHAR(100),
    Courses VARCHAR(100),
    Complaint VARCHAR(255)
);

CREATE TABLE professor (
    ID INT PRIMARY KEY,
    NAME VARCHAR(100),
    passwords VARCHAR(100),
    Syllabus VARCHAR(255)
);

CREATE TABLE admins (
    ID INT PRIMARY KEY,
    NAME VARCHAR(100),
    passwords VARCHAR(100)
);

CREATE TABLE courses (
    ID VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(100),
    Credits INT
);
```

---

## ⚙️ Getting Started

### Prerequisites

- Java JDK 8 or higher
- MySQL Server running locally on port `3306`
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) JAR in your classpath

### Configuration

In `database.java`, update the credentials if needed:

```java
private static final String url = "jdbc:mysql://localhost:3306/studentmanagementdb";
private static final String username = "root";
private static final String password = "your_password_here";
```

### Compilation

```bash
javac -cp .;mysql-connector-j-x.x.x.jar *.java
```

> On Linux/macOS, replace `;` with `:` in the classpath.

### Running

```bash
java -cp .;mysql-connector-j-x.x.x.jar assignment1
```

---

## 🖥️ Usage Flow

```
Enter operation to perform :
--> 1. Register new user
--> 2. Login registered user
```

On registering, the user is assigned a unique **ID** which is used for all future logins.  
On login, users are presented with role-specific options as described in the Features section above.

---

## 🏗️ Tech Stack

| Component | Technology               |
|-----------|--------------------------|
| Language  | Java                     |
| Database  | MySQL                    |
| DB Driver | MySQL Connector/J (JDBC) |
| Interface | Console (Scanner-based)  |
| Paradigm  | OOP + Interface (`user`) |

---

## 📐 Design Notes

- All roles implement the `user` interface, which defines a common `login()` method.
- `Setuser` acts as a simple factory that returns the correct role object (`student`, `professor`, or `admin`) based on a string input.
- All database interactions are centralized in `database.java` using `PreparedStatement` to guard against SQL injection.

---

## ⚠️ Security Notice

> Passwords are currently stored as **plain text** in the database. For production use, consider hashing passwords using a library like [BCrypt](https://github.com/patrickfav/bcrypt).

---

## 👨‍💻 Author

**Atharva Nalbalwar**  
GitHub: [@atharvanalbalwar-a11y](https://github.com/atharvanalbalwar-a11y)

---

## 📄 License

This project is for educational purposes. Feel free to use and modify it.
