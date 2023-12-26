# java-resilience4j

Experiment with resilience4j with spring-boot 3 on Java 17.

## Project Structure
-> resilience4j - Service with Resilience4j that interacts with the faulty services.

-> backend[a-z] - Faulty services.

## Resilience4j Fault Tolerance Tests

| module      | client       | server       | description                                           |
|-------------|--------------|--------------|-------------------------------------------------------|
| Retry       | resilience4j | backenda     | Server returns xception 50% of time.                  |
| RateLimiter | localhost    | resilience4j | Server endpoint protected by 1 req / 10s ratelimiter. |

## Resilience4j Supplementary Notes
[Official Documentation](https://resilience4j.readme.io/)

### RateLimiter Module
Paramters
* timeoutDuration - Amount of time a request waits before a timeout exception is returned.
* limitRefreshPeriod - The duration of epoch cycle. At the end of each cycle the number of total allowed requests is set to `limitForPeriod`.
* limitForPeriod - Number of requests allowed during the `limitRefreshPeriod`.
