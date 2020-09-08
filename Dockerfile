
FROM java:8
EXPOSE 8085
ADD /target/hotelmanagement-0.0.1-SNAPSHOT.jar hotelmanagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "hotelmanagement-0.0.1-SNAPSHOT.jar"]
