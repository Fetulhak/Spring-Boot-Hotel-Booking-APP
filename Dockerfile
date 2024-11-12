FROM openjdk:21-ea-18-buster
ADD target/fetulhak-docker.jar fetulhak-docker.jar
ENTRYPOINT ["java","-jar","/fetulhak-docker.jar"]