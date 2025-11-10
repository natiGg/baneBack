
# Bane Migration Tool - Backend

This is the **Spring Boot backend** for the Bane Migration Tool. It provides REST APIs to manage legacy clients and migrate them to the new system.

## Technologies
- Java 17
- Spring Boot 3
- Lombok
- REST API using Spring Web
- In-memory storage (List)
- CORS configured for frontend
- Stateless security (simple configuration)

## Running the Backend
1. Navigate to the backend folder:
```bash
cd bane
```
2. Build and run the application:
```bash
mvn clean install
mvn spring-boot:run
```
3. Backend API runs at: `http://localhost:8080`

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | /api/legacy/clients | Returns a list of clients in the legacy system |
| GET | /api/new/clients | Returns a list of clients already migrated |
| POST | /api/migrate/{id} | Migrates a client to the new system. Returns a message like "Client migrated successfully" or "Client is already migrated" |

### Example Response:
```json
{
  "clientId": 1,
  "message": "Client migrated successfully"
}
```

## Security Features

- **CORS enabled**: Allows requests from frontend (`localhost:5173`) or any allowed origin.
- **Stateless sessions**: No HTTP session is stored; suitable for SPA.
- **Endpoint protection**: All endpoints are secured using Spring Security, with optional whitelist for public APIs.
- **CSRF disabled**: Allows POST requests from the frontend without CSRF token.
- **ResponseEntity used**: Ensures proper HTTP status codes are returned for success or error cases.

> Note: For this test application, authentication is disabled for simplicity. In production, JWT or OAuth2 can be added.

## Features
- View legacy clients and migrated clients.
- Migrate clients with a single API call.
- Console logs "Migrated client {id} successfully".
- Handles simple error cases (already migrated, client not found).
- Uses DTOs to expose only required data to the frontend.
- ResponseEntity used to standardize HTTP status and messages.

