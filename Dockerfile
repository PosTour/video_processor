FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn .mvn

RUN chmod +x mvnw && ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /app/target/video-processor-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]
