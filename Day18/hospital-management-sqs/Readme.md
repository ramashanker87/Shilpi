# To run this Spring Application
## First run the docker compose file to create image of localstack to use sqs service
docker-compose up

## patient-sqs-app is producer to send message 
### run the program - mvn spring-boot:run
### In postman - POST http://localhost:8081/send
data format -
    {
        "name":"Ajay",
        "id": 1,
        "hospitalName":"H1",         
        "age":21,
        "gender":"M"
    }
### spring security basic Auth :username - patient password - patient

## doctor-sqs-app is a receiver 
### run : mvn spring-boot:run
### In postman - GET http://localhost:8082/receive
### spring security basic Auth username - doctor password - doctor
### we will get the data and then deleted from the Amazon SQS
## To check Queue on localstalk 
#### use link - https://app.localstack.cloud/inst/default/status
#### region we selected here - eu-west-1