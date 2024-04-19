FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/pancakehouse-0.0.1-SNAPSHOT.jar pancakehouse.jar
ENTRYPOINT ["java", "-jar", "pancakehouse.jar"]