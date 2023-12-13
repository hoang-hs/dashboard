FROM gradle-jdk21 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the build files to the container
COPY ./build.gradle .
COPY ./src ./src

# Build the application using Gradle
RUN gradle build --no-daemon

# Create a new stage for the final image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Configure the container to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
