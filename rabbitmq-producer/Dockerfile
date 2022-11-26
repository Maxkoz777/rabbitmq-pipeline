FROM openjdk:19-jdk-slim-buster

ARG JAR_FILE=target/*.jar

WORKDIR /rabbitmq-producer

COPY ${JAR_FILE} app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/rabbitmq-producer/app.jar"]