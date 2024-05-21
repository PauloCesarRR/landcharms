FROM gradle:8.7.0-jdk21-alpine AS builder

WORKDIR /usr/app/

COPY . .

RUN gradle bootJar

# build runtime
FROM eclipse-temurin:21.0.2_13-jre-alpine
WORKDIR app

COPY --from=builder /usr/app/build/libs/application.jar /build/libs/application.jar

CMD java -jar /build/libs/application.jar