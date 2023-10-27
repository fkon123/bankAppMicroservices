# bankApp

sos commands

start app --> mvn spring-boot:run

build --> mvn clean install

build image --> cd bankApp/accounts$ docker build . -t fkon/accounts:s4
run img to container --> docker run -p 8090:8090 fkon/accounts:s4, docker run -d -p 8090:8090 fkon/accounts:s4

