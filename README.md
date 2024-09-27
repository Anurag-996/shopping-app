# Shopping App API

Welcome to the Shopping App API! This Spring Boot application offers a comprehensive solution for e-commerce platforms.

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Cloning Repository](#cloning-repository)
  - [Configuration](#configuration)
  - [Building and Running](#building-and-running)

## Introduction

Shopping App API is a Spring Boot application designed to provide an API for an e-commerce shopping platform. It offers functionalities such as user authentication, product management, order processing, and more.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following prerequisites installed on your system:

- **Java Development Kit (JDK)**: Download and install the latest version of the JDK from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Maven**: Install Maven, the build automation tool, from [here](https://maven.apache.org/download.cgi).
- **MySQL**: Make sure you have MySQL installed and running on your system. Download MySQL from [MySQL Downloads](https://dev.mysql.com/downloads/).

### Cloning Repository

To get a local copy of the project up and running, follow these simple steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/Anurag-996/shopping-app

### Configuration

2. Open `application.properties` from `src/main/resources/application.properties` and update the username and password:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/shoppingApi?createTableIfNotExist=true
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update

### Building and Running

3. Open a terminal and type the following command to package the application:

   ```bash
   mvn package

This will create a .jar file in the target folder.

4. Navigate to the target folder in the terminal and run the following command to execute the .jar file:

   ```bash
   java -jar your-jar-file.jar

Replace your-jar-file.jar with the actual name of the .jar file generated in the target folder.


