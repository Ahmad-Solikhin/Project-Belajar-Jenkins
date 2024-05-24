FROM maven:3.8.5-eclipse-temurin-17-alpine as build

WORKDIR app

COPY src ./src
COPY pom.xml .

RUN mvn clean -DskipTests package

FROM openjdk:17-jdk-alpine
LABEL authors="ahmadsgr39"

#RUN apk add openjdk17-jdk

WORKDIR app

EXPOSE 9000/tcp

COPY --from=build /app/target/personal-project-online-test.jar spring-boot.jar

ENTRYPOINT ["java", "-jar", "spring-boot.jar"]