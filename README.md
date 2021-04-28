# sales-pipeline
## _Sales pipeline_

[![Build Status](https://travis-ci.com/ms-vieira/sales-pipeline.svg?token=26erj8ReictAxUzuchaR&branch=master)](https://travis-ci.com/ms-vieira/sales-pipeline)
[![codecov](https://codecov.io/gh/ms-vieira/sales-pipeline/branch/master/graph/badge.svg?token=49B4JH4B0G)](https://codecov.io/gh/ms-vieira/sales-pipeline)

Basic sales pipeline service, where leads can convert into potential customers, simulating integrations between other services and returning the customer's status, converted or not.


## Decisions
- The service was created using the Domain-driven Design (DDD) architecture, organized by resources, repositories, services and components.
- To perform the mocks, java objects were used and to simulate latency between integrations, thread sleep was used.
- Unit testing of the business service was performed using Junit and mockito.
- The integration test between the system components was done with MockMvc.
- An API specification with the swagger was used to facilitate the execution of the service.


## Assumptions or Improvements

- It could go up in stubby containers to simulate integrations closer to the real environment.
- If you have more validations to create, you could segregate the components and separate into another class of business service.
- Create more unit tests for each component.


## Tech

- [Java]
- [Gradle]
- [Spring Boot]
- [Swagger]
- [Lombok]

## Running the application
- Swagger UI

```sh
./gradlew clean build bootrun
```

- Access to the application specification
```sh
http://localhost:8080/swagger-ui.html
```

- Test
```json

Access the resource / sales / pipeline / {name}

Enter the name Chris

```

[Lombok]: <https://projectlombok.org>
[Swagger]: <http://springfox.github.io/springfox/docs/current>
[Spring Boot]: <https://spring.io/projects/spring-boot>
[Java]: <https://www.oracle.com/br/java>
[Gradle]: <https://gradle.org>
[Junit]: <https://junit.org/junit5/docs/current/user-guide>
[MockMvc]: <https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html>