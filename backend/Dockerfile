# 2 part dockerfile
# First we use the gradle image to use gradle to build our jar
# then we run our java 17 image to run the .jar file
FROM gradle:latest AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

# Don't want long-living daemon in CI/CD
RUN gradle build


# 2nd part
FROM openjdk:17-jdk-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/backend.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=dockerembbed,oauth-security", "-jar","/app/backend.jar"]
