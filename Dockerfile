FROM adoptopenjdk/openjdk11-openj9:alpine-slim
ARG JAR_FILE=target/productapp-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]