FROM openjdk:17-alpine

COPY . .

RUN sh gradlew build

ARG JAR_FILE=*.jar
COPY build/libs/${JAR_FILE} application.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/application.jar"]