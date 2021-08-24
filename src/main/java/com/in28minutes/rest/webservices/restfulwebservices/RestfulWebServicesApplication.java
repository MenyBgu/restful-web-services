package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

}
/**
 * #RESTful Web Services
 *
 * Social Media App
 *
 * User -> Posts (One->Many)
 *
 * -Retrieve all Users - GET /users
 * -Create a User      - POST /users
 * -Retrieve one User  - GET /users/{id}    ->  /users/1
 * -Delete a User      - DELETE /users/{id} ->  /users/1
 *
 * Retrieve all posts for a User - GET /users/{id}/posts
 * Create a posts for a User - POST /users/{id}/posts
 * Retrieve details of a post - GET /users/{id}/posts/{post_id}
 */
