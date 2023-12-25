# java-resilience4j

Experiment with resilience4j with spring-boot 3 on Java 17.

## Project Structure
-> resilience4j - Service with Resilience4j that we'll refer to as the client.

-> backend[a-z] - Faulty services that we'll refer to as the servers.

## Resilience4j Fault Tolerance Tests

| module   | server   | description                                           |
|----------|----------|-------------------------------------------------------|
| retry    | backenda | REST request to server that hasn't started yet.       |