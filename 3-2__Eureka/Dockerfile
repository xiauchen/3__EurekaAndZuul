FROM openjdk:8-alpine
RUN mkdir demoA
COPY target/3-2__eureka-v1.0.jar /demoA
WORKDIR /demoA
ENTRYPOINT ["java","-jar","3-2__eureka-v1.0.jar"]