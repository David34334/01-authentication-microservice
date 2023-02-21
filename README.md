# Authentication Microservice

#### Authentication Microservice for ProductCustomerApp.

This repository allows you the management of all authentication necessary for ProductCustomerApp.

#### Repository contains:

* #### Custom Exceptions.
* #### JWT security.
* #### Necessary endpoint to validate session & validate JWT token.

<hr/>

#### Port `8080`

<hr />

#### Endpoints

`http://localhost:8080/api/v1/auth/validate` Validate if Token is correct.
* #### Requirements:
  * Send `Authorization` header with the Bearer token.

`http://localhost:8080/api/v1/user-auth` Authenticate any user register in database.
* #### Requirements:
    * Send `AuthCustomerDto` in body request with `user_email` & `user_password`.


### Required Libraries
This project need some local libraries to run:

* #### Product Customer Library
  * `product-customer-lb`: This library contains custom exceptions and transversal dtos used in many microservices. [Product Customer App - Library](https://github.com/David34334/product-customer-library)


### Swagger Documentation

--**[Pending]**--
