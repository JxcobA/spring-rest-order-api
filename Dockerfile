FROM openjdk:26-ea-trixie
 
COPY target/order-management-0.0.1-SNAPSHOT.jar app.jar
 
EXPOSE 9000
 
ENTRYPOINT ["java", "-jar", "app.jar"
