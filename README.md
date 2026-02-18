# E-Commerce System
A lightweight, containerized E-Commerce management system built in **Java**.\
This project demonstrates a raw implementation of an MVC architecture without relying on heavy frameworks like Spring Boot. It includes a fully Dockerized environment for easy deployment and database management.

### 🛠️ Tech Stack:
---
* **Language:** Java (JDK 21 or later recommended)
* **Build Tool:** Maven
* **Database:** PostgreSQL 16
* **Infrastructure:** Docker & Docker Compose

### 📦 How to run:
---
You do not need to install Java or PostgreSQL locally. You only need Docker.

1. **Clone Repository**
``` 
git clone https://github.com/GuilhermeLeite/e-commerce.git
cd e-commerce 
```

2. **Build and run**
```
docker-compose up --build
```

3. **Stop the application**
Press ``Ctrl+C`` or run:
```
docker-compose down
```
