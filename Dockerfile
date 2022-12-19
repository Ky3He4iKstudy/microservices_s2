FROM gradle:7.1.1-jdk16-hotspot AS build
WORKDIR /app
COPY server2 .
RUN chmod +x ./gradlew
RUN gradle :server2:bootJar

FROM openjdk:15-jdk-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /app/server2/build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
