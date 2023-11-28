# JWT Authentication with Spring Boot and Spring Security


> This project demonstrates the implementation of JSON Web Token (JWT) authentication in a Spring Boot application using Spring Security.

## Why I created this project
I developed this project to showcase how to integrate JWT authentication into a Spring Boot application. Understanding the principles behind JWT and how to implement them in a secure way can be crucial for building secure and scalable web applications.

## Technologies used in this project
- Spring Boot
- Spring Security
- JSON Web Tokens (JWT)
- Maven
- Lombok
- JJWT library for JWT handling
- Postman (for testing API endpoints)


## How to Install and Run the Project
1. Clone this GitHub repository to your local machine.
2. Open the project in your preferred IDE.
3. Make sure you have Maven installed on your local machine.
4. Let Maven download all the project dependencies.
5. Run the application. This will start the Spring Boot application on localhost:8080.

   
## Project Structure
The project structure follows the standard Spring Boot project layout. Key packages include:

- config: Contains configuration classes, including security configuration.
- controller: Holds the API controllers.
- model: Defines the User model.
- security: Manages security aspects, including JWT generation and validation.
- service: Implements user-related services, including authentication.

## How JWT Authentication Works
JSON Web Tokens (JWT) are a compact, URL-safe means of representing claims between two parties. In this project, JWTs are used for user authentication. Here's a brief overview of how the authentication process works:

1. User Authentication: When a user logs in with valid credentials, the server generates a JWT containing the user's information and a secret key.
2. JWT Issuance: The server returns the JWT to the client.
3. Subsequent Requests: The client includes the JWT in the headers of subsequent requests.
4. JWT Validation: The server validates the JWT to ensure its integrity and authenticity.
5. Access Granted: If the JWT is valid, the server processes the request.

   
## How to Use the Project

After starting the application, you can use Postman or any other API testing tool to interact with the exposed endpoints.


### Register a New User

Send a POST request to localhost:8080/api/register with a JSON body containing the username and password:

```json
{
  "username": "your_username",
  "password": "your_password"
}
```


### Authenticate and Get JWT

Send a POST request to localhost:8080/api/authenticate with the same JSON body as above. If the credentials are valid, the response will contain a JWT.

### Access Protected Resource

Send a GET request to localhost:8080/api/protected with the JWT included in the Authorization header:

```json
{
  "Authorization": "Bearer your_generated_jwt"
}
```


If the JWT is valid, you will receive a successful response.



## Conclusion
This project provides a simple yet effective demonstration of implementing JWT authentication in a Spring Boot application. Feel free to explore the code and adapt it to your specific use case. If you have any questions or suggestions, please let me know!
