FROM  openjdk

WORKDIR /app

COPY target/store-data-api-0.0.1-SNAPSHOT.jar /app/spring-app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "spring-app.jar"]