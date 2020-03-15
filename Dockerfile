FROM openjdk:latest
COPY ./target/Group27CW.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group27CW.jar", "db:3306"]