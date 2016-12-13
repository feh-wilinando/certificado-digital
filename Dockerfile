FROM openjdk:8-jdk

COPY target/certificado-digital.jar "/opt/certificado-digital.jar"

EXPOSE 8080

WORKDIR	"/opt"

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "certificado-digital.jar"]