The E‑Commerce Microservices System is a scalable and modular application designed to simulate a real‑world online shopping platform. Instead of a traditional monolithic approach, the system is built using Spring Boot Microservices architecture, ensuring flexibility, scalability, and maintainability.

🔹 Key Features
Product Service

Manages product catalog (add, update, delete, fetch products).

Stores product details such as name, price, description, and stock.

Order Service

Handles customer orders (creation, tracking, cancellation).

Communicates with Product Service to validate stock availability.

Cart Service

Manages shopping cart operations (add to cart, remove items, view cart).

Uses WebClient/FeignClient to interact with Product Service for pricing and availability.

User/Customer Service

Handles customer registration, login, authentication, and profile management.

Implements JWT‑based authentication & role‑based authorization.

Payment Service

Simulates payment processing and order confirmation.

Can be extended to integrate real‑time payment gateways (Razorpay, PayPal, etc.).

API Gateway

Acts as a single entry point for all clients.

Handles routing, authentication, and load balancing.

Eureka Service Registry (Service Discovery)

Enables dynamic discovery of microservices.

Makes the system fault‑tolerant and highly available.

Database Layer

Uses MySQL for persistent storage of products, orders, users, and transactions.

Each service manages its own schema (database per service pattern).

🔹 Tech Stack
Backend: Java, Spring Boot, Spring Cloud (Eureka, API Gateway, Config Server)

Database: MySQL

Security: Spring Security + JWT Authentication

Communication: REST API, WebClient/FeignClient

Build Tool: Maven/Gradle

Frontend (optional): React / Angular / Thymeleaf (if implemented)

API Testing : Postman

🔹 Advantages of Microservices Architecture
Scalability: Each service can scale independently.

Fault Tolerance: Failure of one service does not affect the entire system.

Maintainability: Easy to update or replace individual services.

Flexibility: Allows the use of different tech stacks for different services if needed.

🔹 Example Flow
A user logs in through the API Gateway.

The user browses products via Product Service.

Items are added to the cart through Cart Service.

An order is placed via Order Service, which checks stock from Product Service.

The order is confirmed upon successful transaction in Payment Service.

