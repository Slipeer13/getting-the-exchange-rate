FROM maven:3.6.3-jdk-11-slim AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /app/src/
RUN mvn package -DskipTests

FROM openjdk:17.0.2-jdk-slim-buster

WORKDIR /app

COPY --from=builder /app/target/myapp.jar .

CMD ["java", "-jar", "myapp.jar"]
