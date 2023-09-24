FROM openjdk:17
EXPOSE 9090
ADD target/spring-boot-blogapp.jar spring-boot-blogapp.jar
ENTRYPOINT ["java","jar","/spring-boot-blogapp.jar"]