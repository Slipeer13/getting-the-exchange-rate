
FROM maven:3.6.3-jdk-11-slim AS builder

WORKDIR /app

# Copying the required files for maven build
COPY pom.xml .
COPY src/ /app/src/

# Build the project dependencies
RUN mvn dependency:go-offline

# Build the project package
RUN mvn package -DskipTests

FROM openjdk:17.0.2-jdk-slim-buster

WORKDIR /app

# Copy the built JAR file from the previous stage into this new stage
COPY --from=builder /app/target/myapp.jar .

# Specify the command to run the JAR file
CMD ["java", "-jar", "myapp.jar"]
