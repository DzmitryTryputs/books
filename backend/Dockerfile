FROM maven:3.6.0-jdk-11-slim AS build
COPY backend/src /usr/app/backend/src
COPY backend/pom.xml /usr/app/backend
COPY backend/pom.xml /usr/app
RUN mvn -f /usr/app/backend/pom.xml clean package -DskipTests

FROM openjdk:8
COPY --from=build /usr/app/backend/target/backend-0.0.1-SNAPSHOT.jar /usr/app/backend.jar
ENTRYPOINT ["java","-jar","/usr/app/backend.jar"]