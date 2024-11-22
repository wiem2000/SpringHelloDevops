FROM maven:3.8.3-jdk-11 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:11

COPY --from=build /app/target/docker-spring-demo-0.0.1-SNAPSHOT.jar docker-spring-demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "docker-spring-demo.jar"]

