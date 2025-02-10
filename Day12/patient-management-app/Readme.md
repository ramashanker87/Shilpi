## Import project
Import the project on either eclipse or inellij as a maven import project

## Building

### Maven
This project is maven project which will be build using maven command.

```
$ mvn clean install
```

## Dockerization

```
$ mvn install dockerfile:build
```
## List docker images
```
$ docker images
```

### Running the application in docker container

```
$docker run -p 8080:8080 patient-management-app:0.0.1-SNAPSHOT
```

## List docker running container

```
$ docker ps
```
