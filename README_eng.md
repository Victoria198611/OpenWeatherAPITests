# Automated Tests for OpenWeather API

This project demonstrates an automated API testing framework built with **Java 17, Maven, TestNG, RestAssured, and Allure**.  
The goal is to validate positive and negative scenarios for the OpenWeather service and present Allure reports in an organized and easy-to-understand way.

---

##  Technologies Used
- Java 17
- Maven
- TestNG
- RestAssured
- Allure Reporting

---

##  Project Structure
src
└── test
└── java
└── api
└── WeatherTests.java



---

##  Test Scenarios
- Positive cases (valid city, units, language)
- Negative cases (invalid city, missing parameters, missing API key)
- Response validation (HTTP codes, JSON fields)

---

##  Reporting
Allure reports include:
- Suites and Behaviors grouped by annotations `@Epic`, `@Feature`, `@Story`
- Environment metadata (base URL, tester, framework)
- Categories tab for failed tests

>  One test is intentionally left **failed** (status code 201 instead of 200) to demonstrate how Allure categorizes errors.  
This shows understanding of the diagnostic and reporting process.

---

##  CI/CD
- GitHub Actions pipeline automatically runs tests on every push
- Allure report is generated and published on GitHub Pages
- [View the report](https://victoria.github.io/OpenWeatherAPITests) *(replace with the actual repository link)*

---

##  Author
**Victoria — QA Automation Tester**  
Focus: learning and practicing API testing, with an emphasis on clear reporting and well-structured documentation.