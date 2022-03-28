FROM openjdk:17
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]