# Create ECS infrastructure

## Create VPC Network Infrastructure (Please dont create this )

    aws cloudformation deploy --template-file 1-vpc-networking.yml --stack-name create-vpc-network-infra --capabilities CAPABILITY_NAMED_IAM 

## Create load balancer infra

    aws cloudformation deploy --template-file 2-load-balancer.yml --stack-name prashant-load-balancer-infra --capabilities CAPABILITY_NAMED_IAM 

## Create Security Group infra

    aws cloudformation deploy --template-file 3-security-groups.yml --stack-name prashant-security-group-infra --capabilities CAPABILITY_NAMED_IAM 

## Create ECS Cluster infra

    aws cloudformation deploy --template-file 4-ecs-cluster.yml --stack-name prashant-ecs-cluster-infra --capabilities CAPABILITY_NAMED_IAM 

## Create ECS Service and Task infra

    aws cloudformation deploy --template-file 5-ecs-service-task.yml  --stack-name prashant-ecs-service-task-infra --capabilities CAPABILITY_NAMED_IAM 

### Invoke calculator api using ALB

    curl  "<ALB-DNS-Name>/actuator/health/"

    curl  "http://PrashantMicroserviceALB-610726130.us-east-1.elb.amazonaws.com/actuator/health/"

### Test application using load balancer
    http://PrashantMicroserviceALB-610726130.us-east-1.elb.amazonaws.com/swagger-ui/index.html#
    curl -X GET "http://PrashantMicroserviceALB-610726130.us-east-1.elb.amazonaws.comaddition?a=9&b=5"
    curl -X GET "http://PrashantMicroserviceALB-610726130.us-east-1.elb.amazonaws.comsubstraction?a=9&b=5"
    curl -X POST "http://PrashantMicroserviceALB-610726130.us-east-1.elb.amazonaws.commultiplication?a=9&b=5"
    curl -X PUT "http://PrashantMicroserviceALB-610726130.us-east-1.elb.amazonaws.comdivision?a=9&b=5"

## Create ECS Service and Task infra

    aws cloudformation delete-stack \
        --stack-name create-ecs-service-task-infra \

## Delete pre ECS cluster Stack

    aws cloudformation delete-stack \
        --stack-name create-ecs-cluster-infra \

        aws cloudformation delete-stack --stack-name prashant-security-group-infra

