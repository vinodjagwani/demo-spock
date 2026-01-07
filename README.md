# Spring Boot WebFlux + Spock Demo

This is a **demo Spring Boot WebFlux project** showcasing how to build and test
**reactive REST APIs** using **Java records**, **Project Reactor**, and the
**Spock Framework** for expressive testing.

The goal of this project is to demonstrate:
- Reactive programming with Spring WebFlux
- Clean, immutable domain models using Java `record`
- Modern testing practices with Spock
- Controller testing using `WebTestClient`
- Spring Boot 4–style testing with explicit mocking

---

## 🚀 Tech Stack

- **Java 21+**
- **Spring Boot 4**
- **Spring WebFlux**
- **Project Reactor (Mono / Flux)**
- **Spock Framework (Groovy)**
- **JUnit Platform**
- **Mockito (via `@MockitoBean` for Spring tests)**

---

## 🧪 Testing with Spock

---
- **Tests are written using Spock, which provides:**
- **given / when / then structure**
- **Built-in mocking and interaction testing**
- **Clear, readable specifications**
- **For WebFlux controller tests:**
- **@WebFluxTest is used for slice testing**
- **WebTestClient is used for non-blocking HTTP assertions**
- **@MockitoBean is used to mock Spring-managed beans (Spring Boot 4 style)**
- **⚠️ Important: When using @MockitoBean, Mockito stubbing (when(...).thenReturn(...)) must be used instead of Spock’s >> syntax.**
---