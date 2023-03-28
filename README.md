# Candidate Management REST API

Candidate Management REST API
This is a Spring Boot REST application that provides API endpoints for managing candidate records. The application uses an ORM tool to persist all operations in a database.

## Getting Started

To run the application, first clone the repository to your local machine. Then navigate to the project directory and run the project. The following command can be used to start the application:

```bash
./mvnw spring-boot:run
```

The application will start on port 9090. You can access the API endpoints using the following base URL:

```bash
http://localhost:9090/api/candidates
```

## API endpoints

The following endpoints are available in the API:

### Get all applications

```bash
GET /api/candidates
```

This endpoint returns a list of all applications in the database.

### Get specific application

```bash
GET /api/candidates/{id}

```

This endpoint returns a specific application with the respective id.

### Create a new candidate

```bash
POST /api/candidates

```

This endpoint creates a new application with the properties provided in the request body.

### Update the candidate (searching parameter should be id)

```bash
PUT /api/candidates/{id}

```

This endpoint updates an existing candidate with the properties provided in the request body.

### Remove the candidate (searching parameter should be id)

```bash
DELETE /api/candidates/{id}

```

This endpoint removes an existing candidate with the given id.

## Candidate Object Properties

The candidate object in this application has the following properties:

id(string)
fullName(string)
email(string)
status(string)

These properties represent the most essential properties for managing candidate records in an ATS, however, we can add more properties but for the scope of this project, these properties are enough.
