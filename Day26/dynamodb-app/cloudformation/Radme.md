## Create Docker image

     docker build -t parking-app .

## Create ECR for parking 

    aws cloudformation deploy --template-file 1-parking-ecr-template.yml --stack-name ajay-parking-ecr-repo 

### Login to ECR (for Docker):

    aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 975050323630.dkr.ecr.us-east-1.amazonaws.com

### Tag Image with ECR Repository URL:

    docker tag parking-app:latest 975050323630.dkr.ecr.us-east-1.amazonaws.com/ajay-parking-app:latest

### Push images:

    docker push 975050323630.dkr.ecr.us-east-1.amazonaws.com/ajay-parking-app

### Create VPC Networking(Created only once)

    aws cloudformation deploy --template-file 2-vpc-networking.yml --stack-name vpc-network

### Create Load Balancer and integrate with VPC

    aws cloudformation deploy --template-file 3-1-load-balancer.yml --stack-name ajay-load-balancer

### Create Security Group

    aws cloudformation deploy --template-file 3-2-security-groups.yml --stack-name ajay-security-group


### Create Dynamodb Infrastructure

    aws cloudformation deploy --template-file 4-create-dynamodb.yml --stack-name ajay-dynamodb 

## Create ECS Cluster infra

    aws cloudformation deploy --template-file 5-ecs-cluster.yml --stack-name ajay-ecs-parking-cluster --capabilities CAPABILITY_NAMED_IAM 

## Create ECS Service and Task infra

    aws cloudformation deploy --template-file 6-ecs-service-task.yml  --stack-name ajay-ecs-service-task-parking --capabilities CAPABILITY_NAMED_IAM 

## Start Parking

    curl --location "http://AjayMicroserviceALB-1192552063.us-east-1.elb.amazonaws.com/start/parking' --header 'sessionid: sessionid-1' --header 'Content-Type: application/json' --data '{"carRegNo": "car1","parkingNo":"park1","parkingStatus":"start"}"

##  Parking status

    curl --location 'http://MicroserviceALB-1080849237.us-east-1.elb.amazonaws.com/parking/status?carRegNo=car2&parkingNo=park1'
