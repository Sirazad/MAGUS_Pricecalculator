# Use a base image with JDK 21 installed
FROM openjdk:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/pricecalculator.jar /app/pricecalculator.jar

# Expose port 8080 for the application
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/pricecalculator.jar"]