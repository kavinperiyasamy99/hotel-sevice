
FROM java:8
EXPOSE 8088
ADD /target/hotelmanagement-0.0.1-SNAPSHOT.jar hotelmanagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "hotelmanagement-0.0.1-SNAPSHOT.jar"]
