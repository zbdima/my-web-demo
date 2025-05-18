# Stage 1: Build
FROM amazoncorretto:21-alpine as builder

RUN apk add --no-cache bash unzip

WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew --no-daemon clean build

# Stage 2: Runtime
FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]