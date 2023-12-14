FROM  openjdk:17-jdk-alpine AS builder
RUN apk add --no-cache maven
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=builder /app/target/incident-report-0.0.1-SNAPSHOT.jar incident-report.jar
ENTRYPOINT ["java", "-jar", "incident-report.jar"]