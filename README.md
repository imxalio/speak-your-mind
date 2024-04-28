# SpeakYourMind API

SpeakYourMind is a RESTful API for posting and commenting.

## Table of Contents

1. [Installation](#installation)
2. [Endpoints](#endpoints)
3. [Dependencies](#dependencies)
4. [Angular Frontend](#angular-frontend)
5. [Swagger UI](#swagger-ui)
6. [Contributing](#contributing)
7. [License](#license)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/xalio/SpeakYourMind.git

# Endpoints

## Posts

- **GET /api/v1/post/**: Retrieve all posts.
- **GET /api/v1/post/{id}**: Retrieve a post by ID.
- **POST /api/v1/post/new**: Create a new post.
- **POST /api/v1/post/vote/{id}**: Upvote a post.

## Comments

- **GET /api/v1/post/{id}/comments**: Retrieve comments for a post by ID.
- **POST /api/v1/post/{id}/comment**: Add a new comment to a post.

# Dependencies

- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter Web
- MySQL Connector/J
- Lombok
- Spring Boot Starter Test
- MapStruct
- Springdoc OpenAPI

# Angular Frontend

The Angular frontend for SpeakYourMind is available in the `client-side` directory. Follow the instructions in the
README file located there to set up and run the frontend application.

# Swagger UI

Swagger UI is integrated into the SpeakYourMind API for easy documentation and testing. Once the server is running, you
can access the Swagger UI interface
at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

# Contributing

Contributions are welcome! Please feel free to open issues or pull requests.

# License

This project is licensed under the [MIT License](LICENSE).

