
#FROM java:8
#EXPOSE 8085
#ADD /target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]



#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
##
## Package stage
##
#FROM openjdk:11-jre-slim
#COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
#
#











#
#FROM java:8
#RUN mkdir -p /hotelmanagement-service
#WORKDIR /hotelmanagement-service
#COPY ./ /hotelmanagement-service
#EXPOSE 8088
#ADD /target/hotelmanagement-0.0.1-SNAPSHOT.jar hotelmanagement-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "hotelmanagement-0.0.1-SNAPSHOT.jar"]

FROM frolvlad/alpine-oraclejre8
VOLUME /tmp

RUN apk --update --no-cache add build-base less git openssh bash curl maven

RUN mkdir -p /hotelmanagement-service
WORKDIR /hotelmanagement-service
COPY ./ /hotelmanagement-service

EXPOSE 8088

RUN mvn package -Dmaven.test.skip=true

CMD ["./bin/docker-entrypoint.sh"]