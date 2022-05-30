FROM maven:3-adoptopenjdk AS mavenbild
WORKDIR /newdir
COPY pom.xml ./
COPY src src/
RUN mvn clean install
RUN mvn -f /newdir/pom.xml clean package

FROM eclipse-temurin:17-jre
WORKDIR /otherdir
COPY /target/*.jar ./
EXPOSE 8080
CMD ["java", "-jar", "backend.jar"]
