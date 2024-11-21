FROM openjdk:24-jdk-oraclelinux8

LABEL maintainer="javaguides.net"

COPY target/docker-spring-demo-0.0.1-SNAPSHOT.jar docker-spring-demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "docker-spring-demo.jar"]