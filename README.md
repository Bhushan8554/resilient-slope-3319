
# EZWallet_Application
<hr>
<li>An Collabrative Project Consisting Of the 5 Developer Depicting the implementation of the EZwallet online transaction platform
<li>An developement of RESTful API for an Online Payment Wallet application. This API performs all the fundamental CRUD operations of wallet platform with user validation at every step.
<br>
 
 # Team Member Roles And Responsibilities
  
<hr>
<br>
<br>

1) Bhushan Taru  -Team Lead, Responsible for creating the Beneficiary module and Responsible For handeling the Exceptions .

2) Hari Tripathi -Responsible for creating the Bank Account Module.

3) Vivek Raj -Responsible For Login/Logout authentication and bill payment module .

4) Vinay Kumar -Responsible for creating the Transaction Module and debuging application.

5) Sayali Divate  -Responsible for creating the Wallet Module and ER Daigram.

<br>
<br>


# Modules
<hr>
<li>Login Logout User authentication
<li>CurrentUserSession
<li>Wallet
<li>BankAccount
<li>BeneficiaryDetails
<li>BillPayment
<li>Transaction

<br>
<br>

# Features
<hr>
<br>

- User Login authentication
- validation for the mobile number number
- validation for the account number number and IFSC code
- validation for the current user and user identification
- RESTFUL API with CRUD operations

<br>
<br>


# ER Diagram
<hr>
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>
<br>
  <img src="https://i.ibb.co/6XVkNh0/EZWallet-ER.png" alt="EZWallet-ER" border="0"  width="100%" height="400">

<br>
<br>
<hr>

# Services Table
<hr>
The following Diagram depicts the services of our EZWallet modules
<br>
<br>
  
  
<img src="https://i.ibb.co/K9XNjLb/2.jpg"  width="100%" height="400">
<br>
<br>
<hr>
  


# Teach Stacks Implemented
<hr>
<br>
<br>
<li>Java
<li>Spring framework
<li>Spring Boot Data JPA
<li>Hibernate
<li>Maven
<li>MySQL
<li>Swagger
<li>Lombok

  

<br>
<br>

# Installation & Run
<hr>
<br>
<br>

```
#changing the server port
server.port=8888

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/ezwallet
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

```

<br>
<br>

# API Root Endpoint
<hr>
<br>
<br>

```
http://localhost:8888/
```

```
http://localhost:8888/swagger-ui/#
```
<br>
<br>


# Screenshots



<img src="https://i.ibb.co/PMq2JQK/Screenshot-452.png" alt="Screenshot-452" border="0">
<img src="https://i.ibb.co/PQmb4cS/Screenshot-453.png" alt="Screenshot-453" border="0">
<img src="https://i.ibb.co/PM03DWq/Screenshot-454.png" alt="Screenshot-454" border="0">
