# Spring Boot Custom Authentication Filter Assignment

## Project Details
- Java Version: Java 17
- Spring Boot Version: 3.2.4

## Important Decisions
- Used ThreadLocal to store the authentication header value.
- Implemented a custom authentication filter to check the presence of the header.
- Created a Spring MVC controller to retrieve the header value from ThreadLocal.

## Instructions to Run the Application
1. Clone the project repository.
2. Open the project in your preferred IDE (e.g.,STS , IntelliJ IDEA).
3. Build the project using Maven or Gradle.
4. Run the application as a Spring Boot Application.
5. Use Postman or any other tool to send GET requests to `http://localhost:8080/` with the header `PinggyAuthHeader` set to a non-empty value.
6. Verify the response containing the authentication header value.
