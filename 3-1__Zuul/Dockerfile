FROM openjdk:8-alpine
RUN mkdir demoA
COPY target/3-1__zuul-v1.0.jar /demoA
WORKDIR /demoA
ENTRYPOINT ["java","-jar","3-1__zuul-v1.0.jar"]