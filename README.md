# Property Management Service

A RESTful API service for managing real estate property listings with full-text search capabilities.

## Overview

This service provides CRUD operations for property listings with an approval workflow. It features:

- Property creation and updates
- Approval/rejection workflow for property listings
- Full-text search using Hibernate Search (Lucene)
- API Key authentication
- Swagger/OpenAPI documentation

## Architecture

```
property-management/
├── property-api/          # Generated API interfaces from OpenAPI spec
├── property-service/      # Core service implementation
├── property-client/       # Client library for consumers
└── yaml/                  # OpenAPI specification
```

## Tech Stack

| Component | Technology |
|-----------|------------|
| Framework | Spring Boot 2.1.6 |
| Database | H2 (in-memory) |
| ORM | Spring Data JPA + Hibernate |
| Search | Hibernate Search 5.10 (Lucene) |
| Security | Spring Security (API Key auth) |
| API Docs | Swagger 2 / SpringFox |
| Build | Maven |
| Testing | JUnit, Cucumber, REST Assured, WireMock |
| Load Test | Gatling |

## Property Entity

| Field | Type | Description |
|-------|------|-------------|
| id | UUID | Unique identifier |
| name | String | Property name |
| desc | String | Description |
| price | Double | Listing price |
| type | Enum | AGRICULTURE, RESIDENTIAL, COMMERCIAL, INDUSTRIAL |
| status | Enum | PENDING, APPROVED, REJECTED |
| statusComment | String | Approval/rejection reason |

## API Endpoints

Base URL: `/speedhome/backend/v1`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/property` | Create a new property |
| PUT | `/property/{id}` | Update property details |
| PATCH | `/property/{id}` | Approve/reject property |
| GET | `/property?term={keyword}` | Search properties |

All endpoints require `apikey` header for authentication.

## Getting Started

### Prerequisites

- Java 8+
- Maven 3.5+
- Docker (optional)

### Build

```bash
mvn clean install
```

### Run

```bash
cd property-service
mvn spring-boot:run
```

Or with Docker:

```bash
docker build -t property-management .
docker run -p 8080:8080 property-management
```

### API Documentation

Once running, access Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

## Testing

### Unit & Integration Tests

```bash
mvn test
```

### BDD Tests (Cucumber)

```bash
mvn test -Dtest=*CucumberTest
```

### Load Tests (Gatling)

```bash
mvn gatling:test -Dsimulation=CreateDomainSimulation
```

## Configuration

Application properties can be configured in:
```
property-service/src/main/resources/application.properties
```

## License

Apache License 2.0
