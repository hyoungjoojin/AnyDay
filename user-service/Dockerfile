FROM eclipse-temurin:17

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw test

CMD ["./mvnw", "spring-boot:run"]

