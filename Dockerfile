FROM maven:3.5-jdk-8-alpine AS BUILD
LABEL Khoa Vu
WORKDIR /home/app
COPY property-api /home/app/property-api
COPY property-client /home/app/property-client
COPY property-service /home/app/property-service
COPY yaml /home/app/yaml
COPY pom.xml /home/app/
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-alpine
COPY --from=BUILD /home/app/property-service/target/property-service-0.0.1.jar property-service-0.0.1.jar
ENTRYPOINT ["java","-jar","property-service-0.0.1.jar"]
