# Java 17 image that works on Mac (Apple Silicon)
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY target/notebox-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
