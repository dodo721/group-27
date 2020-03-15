FROM openjdk:latest
COPY ./target/Group27CW-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group27CW-0.1.0.3-jar-with-dependencies.jar", "db:3306"]