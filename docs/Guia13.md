# Guide 13 - Configuring the Datasources

## Objective
Configure PostgreSQL as the main datasource for Inklusport Sports Hub.

## Database
- Database: inklusport_db
- Host: localhost
- Port: 5432
- JDBC driver: PostgreSQL

## Configuration
The datasource is configured in application.properties.

## Main properties
- quarkus.datasource.db-kind
- quarkus.datasource.username
- quarkus.datasource.password
- quarkus.datasource.jdbc.url

## Validation
Run the application using:

mvn quarkus:dev

Confirm that Quarkus starts without datasource connection errors.

## Result
PostgreSQL is configured as the application's relational datasource.