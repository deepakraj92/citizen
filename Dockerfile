FROM openjdk:11
COPY ./out/production/DockerCitizenApplication/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","CitizenApplication"]