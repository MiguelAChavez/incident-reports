FROM  openjdk:17-jdk-alpine as builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=builder /target/incident-report-0.0.1-SNAPSHOT.jar incident-report.jar
ENTRYPOINT ["java", "-jar", "incident-report.jar"]