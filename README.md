
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

5) Sayali Divate  -Responsible for creating the Wallet Module ER Daigram.

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

- User Login authrntication
- validation for the mobile number number
- validation for the account number number and IFSC code
- validation for the current user and user identification
- RESTful API with CURD operations

<br>
<br>


# ER Diagram
<hr>
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>
<br>
  
  
![WhatsApp Image 2022-09-27 at 9 52 51 PM](https://user-images.githubusercontent.com/57911117/192693251-f4deedb6-d884-404c-9529-3970e25a8a5f.jpeg)

<br>
<br>
<hr>

# Services Table
<hr>
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>
<br>
  
  
![WhatsApp Image 2022-09-27 at 9 52 51 PM]([https://user-images.githubusercontent.com/57911117/192693251-f4deedb6-d884-404c-9529-3970e25a8a5f.jpeg](https://ibb.co/ZhVH6YG"><img src="https://i.ibb.co/K9XNjLb/2.jpg))

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
https://localhost:8888/
```

```
https://localhost:8888/swagger-ui/#
```
<br>
<br>


# Screenshots

![Swagger UI - Google Chrome 03-10-2022 09_20_51](https://user-images.githubusercontent.com/101331023/193498809-acec52c3-bf24-498a-8478-1b48c69228ea.png)



![Swagger UI - Google Chrome 03-10-2022 09_21_13](https://user-images.githubusercontent.com/101331023/193498829-1cdd1d29-720c-413b-a61b-e376b2d8071f.png)




![Swagger UI - Google Chrome 03-10-2022 09_21_26](https://user-images.githubusercontent.com/101331023/193498841-22886520-b223-4edc-88cb-224b05233aa7.png)



