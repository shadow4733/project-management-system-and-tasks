FROM openjdk:17-jdk-slim
COPY /build/libs/task-management-service-0.0.1-SNAPSHOT.jar /app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app.jar"]