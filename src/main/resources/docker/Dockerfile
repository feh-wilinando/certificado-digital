FROM openjdk:8-jdk

MAINTAINER Fernando Furtado <feh.wilinando@gmail.com>

COPY target/certificado-digital.war target/dependency/webapp-runner.jar "/opt/"

EXPOSE 8080

WORKDIR	"/opt"

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "-jar", "webapp-runner.jar", "--expand-war", "certificado-digital.war"]