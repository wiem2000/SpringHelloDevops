FROM maven:3.8.1-jdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17

COPY --from=build /app/target/docker-spring-demo-0.0.1-SNAPSHOT.jar docker-spring-demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "docker-spring-demo.jar"]
