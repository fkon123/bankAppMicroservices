# bankApp

sos commands

***for local build & run***
start app --> mvn spring-boot:run

build --> mvn clean install

***for Dockerfile***
build image --> cd bankApp/accounts$ docker build . -t fkon/accounts:s4

run img to container --> docker run -p 8090:8090 fkon/accounts:s4, docker run -d -p 8090:8090 fkon/accounts:s4

***for buildpacks image with mvn command***
build image --> mvn spring-boot:build-image

***for jib image with mvn command***
build image --> mvn compile jib:dockerBuild
