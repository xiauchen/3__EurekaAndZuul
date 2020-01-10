FROM openjdk:8-alpine
RUN mkdir demoA
COPY target/3-3-3__postnotesapplication-v1.0.jar /demoA
WORKDIR /demoA
ENTRYPOINT ["java","-jar","3-3-3__postnotesapplication-v1.0.jar"]