
FROM java:8
EXPOSE 8088
ADD /target/hotelmanagement1-0.0.1-SNAPSHOT.jar hotelmanagement1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "hotelmanagement1-0.0.1-SNAPSHOT.jar"]
