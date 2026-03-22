# Automation Framework Overview

## Architecture

This framework is designed using a layered architecture with clear separation of concerns.

### Layers

1. Core Layer
    - Configuration management
    - Constants
    - Custom exceptions

2. UI Layer
    - Page Object Model (POM)
    - Driver management (ThreadLocal + Factory)
    - Utility classes

3. API Layer
    - RestClient for HTTP operations
    - Service classes for business logic
    - Request and Response models (Builder pattern)

4. Test Layer
    - UI Tests
    - API Tests
    - Data providers
    - Listeners (Retry, Reporting)

---

## Design Patterns Used

- Page Object Model (POM)
- Factory Pattern (Driver initialization)
- Singleton + ThreadLocal (Driver management)
- Builder Pattern (API request models)

---

## Key Features

- UI Automation using Selenium
- API Automation using Rest Assured
- Parallel execution support
- Retry mechanism for failed tests
- Extent Reporting with screenshots
- Jenkins integration for CI/CD

---

## Folder Structure

src/main/java
- api
- ui
- core

src/test/java
- api
- ui
- listeners
- base

resources
- config.properties

reports
- extent-report.html
- screenshots