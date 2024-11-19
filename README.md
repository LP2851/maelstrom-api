# maelstrom-api

# Maelstrom API
[![Java CI with Gradle](https://github.com/LP2851/maelstrom-api/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/LP2851/maelstrom-api/actions/workflows/gradle.yml)

## Purpose

This repository contains source code for Maelstrom API.
Maelstrom API is part of a larger project called Maelstrom which is a learning project to create a social media platform.

## Technologies Used
- Java
- Spring Boot
- JPA
- Docker
- Postgres
- Flyway

## Related Repositories
TODO

## What's Inside
This repository contains:
- Application code
- Docker Setup
- Automated testing via GitHub Actions

## Plugins
This repository contains the following plugins:
- [io.spring.dependency-management](https://github.com/spring-gradle-plugins/dependency-management-plugin): Provides Maven-like dependency management. Allows you to declare dependancy management using `dependency 'groupId:artifactId:version'` or `dependency group: 'group', name: 'name', version: 'version'`.
- [org.springframework.boot](https://projects.spring.io/spring-boot/): Reduces the amount of work needed to create a Spring application. 
- [org.flywaydb.flyway](https://www.red-gate.com/products/flyway/community/): Open source database migration tool which runs when the Spring application starts.
- [io.freefair.lombok](https://projectlombok.org)

## Building the Application
This project uses Gradle as a build tool. It contains `./gradlew` wrapper script, so there is no need to install gradle.

To build the project, execute the following command:
```bash
./gradlew build
```

## Running the Application
TODO

## Application Designs
### Database Schema
<iframe width="560" height="315" src='https://dbdiagram.io/e/66c64176a346f9518cb7889b/66c64252a346f9518cb79774'></iframe>