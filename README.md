### Spring Cloud
Spring cloud project with Eureka server for microservices registration and discovery, as well as Ribbon for payment service load balancing.

### Usage
* Launch the Eureka Server, with the default port set to 8761. 
* Launch the Payment Service. To run a separate instance of the Payment Service, modify the port and start the application. 
* Launch the Client Portal with the default port set to 8080. On the client portal, the spring cloud ribbon dependency is added for load balancing the Payment Service.

When used with Eureka, the Ribbon automatically balances the client side load via a round robin mechanism.

### Image
<img width="1469" alt="image" src="https://github.com/deepakma76/spring-cloud/assets/17908283/9088d06a-c5a4-42b0-b33d-37d8af6d08cb">
