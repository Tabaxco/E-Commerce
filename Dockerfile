FROM eclipse-temurin:21-jdk-alpine

COPY target/ecommerce-project-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]