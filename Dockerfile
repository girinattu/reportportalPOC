FROM openjdk:8-jdk-alpine
RUN mkdir -p /app
VOLUME /app
WORKDIR /app
COPY ./target/io.springs.api.data-1.0-SNAPSHOT.jar /app
EXPOSE 8090
ENTRYPOINT ["java","-jar","io.springs.api.data-1.0-SNAPSHOT.jar"]