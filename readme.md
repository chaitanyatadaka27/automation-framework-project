# Test Automation Framework

## Overview

This project is a hybrid automation framework supporting both UI and API testing.

- UI Automation: Selenium WebDriver
- API Automation: Rest Assured
- Test Execution: TestNG
- Reporting: Extent Reports
- CI/CD: Jenkins

---

## Prerequisites

- Java 21
- Maven
- Chrome/Firefox browser
- IDE (IntelliJ recommended)

---

## Project Setup

1. Clone the repository
2. Open the project in your IDE
3. Install dependencies using Maven

---

## Configuration

Update the file:

src/test/resources/config.properties

Example:

browser=chrome
ui.url=http://localhost:8080
username=admin
password=admin
api.base.url=http://localhost:8080

---

## Running Tests

### Run UI Tests

mvn clean test -DsuiteXmlFile=testng-ui.xml

### Run API Tests

mvn clean test -DsuiteXmlFile=testng-api.xml

### Run All Tests

mvn clean test -DsuiteXmlFile=testng.xml

---

## Test Location

UI Tests:
src/test/java/com/automation/framework/ui

API Tests:
src/test/java/com/automation/framework/api

---

## Reports

Reports are generated in:

reports/extent-report.html

Screenshots (on failure):

reports/screenshots/

---

## Notes

- Tests support parallel execution using ThreadLocal WebDriver
- Retry mechanism is implemented for failed tests
- All configurations are externalized using properties file
