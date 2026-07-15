# JWT Authentication Exercise

This module demonstrates JWT authentication for a RESTful web service using Spring Security.

## What it includes

- Stateless Spring Security configuration
- Login endpoint that authenticates a user and returns a JWT
- JWT filter that reads the `Authorization: Bearer <token>` header
- Protected REST endpoints that require a valid token
- Role-based admin endpoint

## Default credentials

- `user` / `password`
- `admin` / `admin123`

## Endpoints

- `POST /auth/login`
  - Body:
    ```json
    {
      "username": "user",
      "password": "password"
    }
    ```
  - Returns a JWT access token.

- `GET /api/hello`
  - Requires `Authorization: Bearer <token>`

- `GET /api/admin`
  - Requires the `ADMIN` role and a valid JWT.

## Run

Use the Maven wrapper from this folder:

```bash
mvnw.cmd test
mvnw.cmd spring-boot:run
```

The application runs on port `8085`.
