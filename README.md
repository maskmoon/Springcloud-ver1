# Springcloud-ver1

This project is based on Java language and Spring Framework also combines with some Spring Cloud Eureka servers such as Zuul and Ribbon.

Eureka Server : Holds the information about all the client microservices i.e Admin and User microservice. All clients register themselves with eureka server and use it to communicate with each other.

Zuul gate way : As the traffic entrance of the entire application, zuul receives all requests, such as apps, web pages, etc., and forwards different requests to different processing microservice modules.

Ribbon loader balance : As a client-side load balancer, it can configure all the machines behind Load Balancer in the configuration file, and Ribbon will automatically help to  connect these machines based on certain rules (such as simple polling, random connection, etc.)

