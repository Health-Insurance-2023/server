FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Insurance-0.0.1-SNAPSHOT.jar Insurance.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","Insurance.jar"]