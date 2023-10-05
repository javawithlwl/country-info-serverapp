FROM maven:3.8.1-openjdk-17-slim AS build
RUN mkdir /home/country-info
COPY . /home/country-info
RUN cd /home/country-info && mvn package
RUN cp /home/country-info/target/*.jar country-info.jar
ENTRYPOINT [ "java","-jar","country-info.jar" ]
EXPOSE 8082
