FROM openjdk:17.0.2-jdk-slim-buster
ARG JAR_FILE=build/libs/getting-the-exchange-rate-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
