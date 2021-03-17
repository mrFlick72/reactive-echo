FROM openjdk:11

ADD target/application.jar /usr/local/application/

VOLUME /var/log/onlyone-portal

WORKDIR /usr/local/application/

CMD ["java", "-jar", "application.jar"]