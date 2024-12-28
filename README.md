# JDBC Projects Repository

Welcome to the JDBC Projects Repository! This collection of projects demonstrates various aspects of working with Java Database Connectivity (JDBC), covering everything from basic database operations to advanced features like file handling, multi-database connectivity, and CRUD operations.

---

## 📚 **Contents**

1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Projects Overview](#projects-overview)
5. [Setup Instructions](#setup-instructions)
6. [Usage](#usage)
7. [Contributing](#contributing)
8. [License](#license)

---

## 📖 **Introduction**

This repository serves as a comprehensive resource for understanding and implementing JDBC in Java. The projects within this repository cater to beginners and advanced developers, covering topics like:

- Establishing database connections
- CRUD (Create, Read, Update, Delete) operations
- Handling file uploads
- Interfacing with various databases, including MySQL, Oracle, and MongoDB

---

## 🚀 **Features**

- **Database Connectivity**: Demonstrates how to connect to MySQL, Oracle, and MongoDB using JDBC.
- **CRUD Operations**: Implements Create, Read, Update, and Delete functionalities.
- **File Handling**: Includes examples of file uploads and interaction with the database.
- **Multi-Database Support**: Provides examples of handling different database types.
- **Best Practices**: Showcases clean code practices and efficient database interaction techniques.

---

## 🛠 **Technologies Used**

- **Programming Language**: Java
- **Databases**: 
  - MySQL
  - Oracle
  - MongoDB
- **Libraries**:
  - JDBC Drivers for MySQL and Oracle
  - MongoDB Java Driver

---

## 🗂 **Projects Overview**

1. **Basic Database Connectivity**
   - Establishes connections with MySQL, Oracle, and MongoDB.
   - Verifies successful connections.

2. **CRUD Operations**
   - Basic CRUD examples for each database.
   - Uses Prepared Statements to prevent SQL injection.

3. **File Handling with Databases**
   - Demonstrates file upload functionality.
   - Stores and retrieves files from the database.

4. **Advanced Features**
   - Handling batch operations.
   - Managing transactions (commit and rollback).
   - Stored procedures and callable statements.

5. **Database Interaction Utilities**
   - Common helper classes for managing connections.
   - Reusable utilities for logging and error handling.

---

## 🔧 **Setup Instructions**

1. **Clone the Repository**
   ```bash
   git clone https://github.com/paralkarkedar/jdbc-projects.git
   cd jdbc-projects
   ```

2. **Set Up the Database**
   - Import the SQL scripts from the `/sql-scripts` folder into your database.
   - Ensure you have the correct drivers installed for MySQL, Oracle, and MongoDB.

3. **Update Configuration**
   - Update the database configuration (username, password, URL) in the `db.properties` file located in the `config` folder.

4. **Compile and Run**
   - Use your IDE (e.g., IntelliJ IDEA, Eclipse) or compile via the terminal:
     ```bash
     javac -cp .:path/to/jdbc/driver Main.java
     java -cp .:path/to/jdbc/driver Main
     ```

---

## 📋 **Usage**

Each project is self-contained in its folder. Follow these steps:

1. Navigate to the project directory of interest.
2. Review the `README.md` in the project folder for specific details.
3. Run the `Main.java` file to execute the project.

---

## 🤝 **Contributing**

Contributions are welcome! Feel free to fork this repository and submit pull requests with improvements or additional projects.

---

## 📜 **License**

This repository is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

### 🌟 **Happy Coding!**
