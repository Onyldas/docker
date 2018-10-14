FROM openjdk:10.0.2
EXPOSE 8080
ADD /target/SpringDocker.jar SpringDocker.jar
ARG JAR_FILE
ENV DOCKER_OPTS="-H tcp://127.0.0.1:2375 -H unix:///var/run/docker.sock" DOCKER_HOST=tcp://127.0.0.1:2375
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","SpringDocker.jar"]