FROM openjdk:8-jdk-alpine

MAINTAINER Fernando Furtado <feh.wilinando@gmail.com>

RUN mkdir -p /usr/application && \
	addgroup prac && \
	adduser -G prac -D -h /usr/application/ certificado-digital && \
	chown -R certificado-digital:prac /usr/application/ && \
	chmod g+rwx /usr/application/

COPY certificado-digital.war webapp-runner.jar "/usr/application/"

WORKDIR	"/usr/application/"

USER certificado-digital

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "-jar", "webapp-runner.jar", "--expand-war", "certificado-digital.war"]