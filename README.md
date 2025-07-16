# 📦 Spring Boot REST API with MongoDB

A robust and modern RESTful API built with **Spring Boot 3** and **MongoDB**. This project provides full CRUD operations for managing users and their posts, along with advanced search, embedded documents, authentication, and Docker integration.

---

## 📚 Table of Contents

- [✨ Features](#-features)  
- [🛠 Technologies](#-technologies)  
- [✅ Prerequisites](#-prerequisites)  
- [🚀 Getting Started](#-getting-started)  
- [📡 API Endpoints](#-api-endpoints)  
- [🔐 Security](#-security)  
- [📁 Project Structure](#-project-structure)  
- [📄 License](#-license)

---

## ✨ Features

- ✅ **User Management**: Create, read, update, and delete users.  
- ✅ **Post Management**: CRUD operations for posts.  
- 🔎 **Search Functionality**:  
  - Search posts by title  
  - Full-text search in post body/comments within a date range  
- 💬 **Embedded Comments**: Each post supports a list of embedded comments.  
- 🛡 **Exception Handling**: Global handler for common errors (e.g., not found).  
- 🐳 **Docker Integration**: Easily start a MongoDB container using Docker Compose.  

---

## 🛠 Technologies

| Tool               | Description                            |
|--------------------|----------------------------------------|
| **Java 21**         | Programming language                   |
| **Spring Boot 3.5.3** | Main framework for REST API           |
| **Spring Data MongoDB** | MongoDB integration               |
| **Spring Web**     | RESTful web services                   |
| **Spring Security**| Basic authentication                   |
| **MongoDB**        | NoSQL database                         |
| **Maven**          | Dependency management                  |
| **Docker**         | MongoDB containerization               |
| **Lombok**         | Cleaner and less boilerplate code      |

---

## ✅ Prerequisites

Ensure the following are installed on your machine:

- Java JDK 21+
- Apache Maven
- Docker + Docker Compose

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/springboot-rest-api-mongodb.git
cd springboot-rest-api-mongodb
```

### 2. Start MongoDB with Docker Compose

```bash
docker-compose up -d
```

- MongoDB will be available at `localhost:27018`.

### 3. Run the application

```bash
mvn spring-boot:run
```

- API available at `http://localhost:8080`

---

## 📡 API Endpoints

### 👤 User Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`  | `/users` | Get all users |
| `GET`  | `/users/{id}` | Get user by ID |
| `POST` | `/users` | Create a user |
| `PUT`  | `/users/{id}` | Update a user |
| `DELETE` | `/users/{id}` | Delete a user |
| `GET`  | `/users/{id}/posts` | Get posts by user ID |

### 📝 Post Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`  | `/posts/{id}` | Get post by ID |
| `GET`  | `/posts/titlesearch?text=xyz` | Search posts by title |
| `GET`  | `/posts/fullsearch?text=xyz&minDate=yyyy-mm-dd&maxDate=yyyy-mm-dd` | Full-text search with date range |

---

## 🔐 Security

This API uses **Basic Authentication** via Spring Security.

**Default Credentials:**

- **Username**: `admin`  
- **Password**: `admin`

You can change them in `application.properties`.

---

## 📁 Project Structure

```
springboot-rest-api-mongodb/
├── compose.yaml                  # Docker Compose configuration
├── pom.xml                       # Maven dependencies
├── src/
│   ├── main/
│   │   ├── java/org/api/springbootrestapimongodb/
│   │   │   ├── SpringbootRestApiMongodbApplication.java
│   │   │   ├── config/           # App config and security setup
│   │   │   ├── domain/           # MongoDB document models
│   │   │   ├── dto/              # Data transfer objects
│   │   │   ├── repository/       # Mongo repositories
│   │   │   ├── resources/        # REST controllers
│   │   │   └── service/          # Business logic
│   └── resources/
│       └── application.properties
└── test/                         # Unit tests
```

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
