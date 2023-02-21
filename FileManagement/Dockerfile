# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/FileManagement.jar

# cd /opt/app
WORKDIR /FileManagement

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080