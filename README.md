# Transfer API

A simple Java 8 REST API for transferring money between accounts.

## Features
- Java 8, Spring Boot
- In-memory data store
- SOLID design principles
- Standalone executable (no pre-installed server required)
- REST endpoints for transfer and account listing
- JUnit tests for API validation

## How to Run

1. **Build the project:**
   ```
   mvn clean package
   ```
2. **Run the application:**
   ```
   java -jar target/transferapi-1.0.0.jar
   ```

## API Endpoints
- `POST /api/transfer` — Transfer money between accounts
- `GET /api/accounts` — List all accounts and balances

## Testing
Run all tests with:
```
mvn test
```

## Example Request
```
POST /api/transfer
{
  "fromAccountId": "A",
  "toAccountId": "B",
  "amount": 100
}
```
