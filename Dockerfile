FROM openjdk:10.0.2
EXPOSE 8080
ADD /target/SpringDocker.jar SpringDocker.jar
ARG JAR_FILE
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","SpringDocker.jar"]