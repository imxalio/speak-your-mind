# SpeakYourMind API

## Overview
This API provides endpoints for managing posts and comments in the SpeakYourMind platform.

## Technologies Used
- Java
- Spring Boot
- Swagger UI

## Installation
1. Clone the repository: `git clone [repository_url]`
2. Navigate to the project directory: `cd speak-your-mind`
3. Build the project: `./mvnw clean install`

## Usage
1. Start the application: `./mvnw spring-boot:run`
2. Access the Swagger UI for API documentation: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Endpoints

### GET /api/v1/post/
- Description: Retrieve all posts.

### GET /api/v1/post/{id}
- Description: Retrieve a post by ID.
- Path Variable: id (UUID) - The ID of the post to retrieve.

### POST /api/v1/post/
- Description: Create a new post.
- Request Body: PostDTO object.

### POST /api/v1/post/{id}/comment
- Description: Add a comment to a post.
- Path Variable: id (UUID) - The ID of the post to add the comment to.
- Request Body: CommentDTO object.

### POST /api/v1/post/{id}
- Description: Upvote a post.
- Path Variable: id (UUID) - The ID of the post to upvote.

