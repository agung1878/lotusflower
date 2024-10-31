# Start with a base image that includes Java
FROM openjdk:21

# Copy the JAR file produced by Maven or Gradle to the container
COPY target/lotusflower-journal-0.0.1-SNAPSHOT.jar app.jar

# Set the entry point to run the app
ENTRYPOINT ["java", "-jar", "/app.jar"]