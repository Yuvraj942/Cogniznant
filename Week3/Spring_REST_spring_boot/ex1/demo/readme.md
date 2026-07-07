# Spring Boot Fundamentals Exercise

This repository demonstrates the core concepts of building a Spring Boot application, including application bootstrapping, dependency injection via legacy XML configuration, and logging setup.

## 1. The Need and Benefits of Spring Boot

Spring Boot was introduced to streamline the development of Spring-based applications by removing heavy configuration requirements. 

**Key Benefits:**
* **Makes Java Development Easy:** Provides "opinionated defaults" so developers can focus on business logic rather than framework configuration.
* **Reduces Development Time:** Starter dependencies (`spring-boot-starter-web`) automatically pull in required, version-compatible libraries.
* **Avoids Boilerplate Code:** Replaces verbose setups with simple annotations.
* **Embedded Servers:** Includes embedded Tomcat (or Jetty/Undertow), allowing the application to run as a standalone Java program (`jar`) instead of needing a separate web server deployment (`war`).
* **Avoids XML Configuration:** While Spring originally relied heavily on XML, Spring Boot allows for purely Java-based configuration using annotations.

## 2. Creating a Spring Boot Application

This project was bootstrapped using [Spring Initializr](https://start.spring.io/), a web-based tool that generates the foundational structure and build scripts (Maven/Gradle) for Spring Boot projects.

The entry point of this application is the main class annotated with `@SpringBootApplication`:

* **`@SpringBootApplication`**: This is a powerful convenience annotation that bundles three core features:
  1. `@Configuration`: Tags the class as a source of bean definitions for the application context.
  2. `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
  3. `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the specified package.
* **`SpringApplication.run()`**: This method provides the bridge between standard Java execution and the Spring framework. It launches the application, initializes the Spring Context, and starts the embedded web server.

## 3. Loading Beans from a Spring Configuration File

Although modern Spring Boot prefers annotations, understanding legacy XML configuration is crucial for understanding Spring's Inversion of Control (IoC) Container.

### Core Concepts Demonstrated
* **IoC Container:** The core of the Spring Framework. It creates objects (beans), wires them together, configures them, and manages their entire lifecycle.
* **Spring XML Schema:** Defined using `spring-beans.xsd`, which standardizes the `<bean>`, `<constructor-arg>`, and `<property>` tags.
* **Scopes:**
  * **Singleton (Default):** The IoC container creates a single, shared instance of the object. Every request for this bean returns the same instance.
  * **Prototype:** The IoC container creates a new instance of the object every time it is requested.
* **Dependency Injection Types:**
  * **Setter Injection:** Injecting dependencies using setter methods, defined in XML using the `<property name="..." value="..." />` tag.
  * **Constructor Injection:** Injecting mandatory dependencies through the class constructor, defined using the `<constructor-arg>` tag.

**How it is loaded:**
In this project, the `ClassPathXmlApplicationContext` (an implementation of `ApplicationContext`) is used to read `spring-beans.xml` and instantiate the beans. We then retrieve the instantiated objects using `context.getBean("beanId")`.

## 4. Configuring Logging in Spring Boot

Spring Boot uses Commons Logging for all internal logging but defaults to **SLF4J** and **Logback** for the underlying log implementation.

Logging is configured without XML, entirely within `application.properties`:
* **`server.port`**: Customizes the embedded Tomcat port.
* **`logging.level`**: Controls the severity of logs printed to the console. Setting `logging.level.root=WARN` ensures only warnings and errors print globally, while `logging.level.com.example=DEBUG` enables granular, verbose logging just for our custom packages.
* **`logging.pattern.console`**: Defines the exact string format of the log output (e.g., timestamps, thread names).

**Log Levels Used:**
Using the `LoggerFactory` to instantiate a `Logger`, this application demonstrates the hierarchy of log levels (from least to most severe):
1. **TRACE**: Very granular diagnostic information.
2. **DEBUG**: Information useful for debugging application flow.
3. **INFO**: General operational messages highlighting application progress.
4. **WARN**: Potentially harmful situations that are not yet errors.
5. **ERROR**: Severe error events that might cause the application to fail.