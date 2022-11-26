FROM openjdk:19-jdk-slim-buster

ARG JAR_FILE=target/*.jar

WORKDIR /rabbitmq-consumer

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/rabbitmq-consumer/app.jar"]