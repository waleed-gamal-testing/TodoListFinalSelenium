

# 🚀 To-Do List Automation Testing Framework

## Overview
This project provides a **comprehensive Automation Testing Framework** for a **To-Do List application**. Built with **Selenium WebDriver**, **TestNG**, and best practices such as **Page Object Model (POM)**, **data-driven testing**, and **state-independent testing**, it ensures **scalable**, **reliable**, and **efficient** test automation for web applications.

Key Features:
- **Automated tests** for **Login**, **Registration**, **Add Task**, and **Delete Task**.
- **State-independent testing**, ensuring tests don’t depend on previous app states.
- **Cross-browser support** (Chrome, Firefox, Edge).
- **Parallel execution** for faster feedback.
- **Allure Reporting** with **screenshots**.
- **CI/CD integration** with **GitHub Actions** to run tests in the cloud.

---

## Project Structure

Here’s the structure of the project:

To-Do-List-Automation-Testing/ │ ├── src/ │ ├── main/ │ │ └── java/ │ │ └── com/ │ │ └── todoapp/ │ │ ├── base/ # Base classes for setup and teardown │ │ ├── pages/ # Page Object Model (POM) classes │ │ ├── tests/ # Test classes and scenarios │ │ ├── utils/ # Utility classes (e.g., waits, file handling) │ │ ├── config/ # Configuration classes (properties files) │ │ └── api/ # API testing classes (RestAssured integration) │ │ │ └── test/ │ └── java/ │ └── com/ │ └── todoapp/ │ ├── tests/ # TestNG test cases │ └── data/ # Test data (JSON, Excel files) │ ├── .gitignore ├── allure-results/ # Allure report results ├── .github/ │ └── workflows/ │ └── selenium-tests.yml # GitHub Actions workflow file ├── pom.xml # Maven build file └── README.md # This README file

yaml
Copy
Edit

---

## Setup & Installation

### Prerequisites

Before getting started, make sure you have the following tools installed:

- **Java 11+**
- **Maven** (for dependency management)
- **Git** (for version control)
- **IDE** (e.g., IntelliJ IDEA, Eclipse)
- **WebDriver** for browsers (e.g., ChromeDriver, GeckoDriver)

### 1. Clone the repository

Clone the repository to your local machine:

```bash
git clone https://github.com/your-username/To-Do-List-Automation-Testing.git
cd To-Do-List-Automation-Testing
2. Install dependencies
Install the required dependencies using Maven:

bash
Copy
Edit
mvn clean install
3. Configure WebDriver
Make sure the appropriate WebDriver for the browser you want to use (e.g., ChromeDriver, GeckoDriver) is available on your system. You can download WebDriver from the respective browser vendor’s website or manage it via a WebDriver manager.

Key Features & Architecture
1. Page Object Model (POM)
The POM Design Pattern is implemented to separate UI interactions from the test logic. Each page in the application has a corresponding Page Object class that contains methods for interacting with the page's elements.

Base Page Class provides common functionality.
Individual Page Objects represent distinct pages (e.g., Login, Todo List).
2. Driver Management (Driver Holder & Factory)
Driver Factory dynamically creates WebDriver instances.
Driver Holder shares WebDriver instances across tests and ensures proper cleanup.
Cross-browser support: Chrome, Firefox, Edge.
3. Test Data Management
Test data is managed through:

POJO classes for structured data.
JSON and Excel files for data-driven testing.
4. State-Independent Testing
Each test case is state-independent. Login and registration are reset for each test, ensuring no dependency on previous test states.

Tests start fresh: no user data or app state dependencies.
Each test is isolated.
5. API Testing with RestAssured
RestAssured is integrated to handle API requests for user login, registration, and interaction with the To-Do List.
State-independent API tests ensure login and registration do not interfere with UI tests.
6. Parallel Test Execution with TestNG
TestNG is used for managing and executing tests:

Parallel execution improves test efficiency.
Tests are configured for method-level or class-level parallel execution.
7. Reporting with Allure
Screenshots are captured after every test method and included in Allure reports.
Allure Reporting generates detailed, visually appealing test reports with logs, screenshots, and execution data.
8. Continuous Integration (CI)
The framework is integrated with GitHub Actions for cloud-based test execution:

Automates tests on every push to the repository.
Ensures continuous feedback and testing.
How to Run Tests
Running Tests Locally
Run all tests locally using Maven:

bash
Copy
Edit
mvn clean test
Running Tests in Parallel
To enable parallel execution, modify the testng.xml configuration:

xml
Copy
Edit
<suite name="TodoAppSuite" parallel="tests" thread-count="4">
    <test name="LoginTests">
        <classes>
            <class name="com.todoapp.tests.LoginTest"/>
        </classes>
    </test>
    <test name="ToDoTests">
        <classes>
            <class name="com.todoapp.tests.ToDoTest"/>
        </classes>
    </test>
</suite>
This will run the tests concurrently across multiple threads.

Running Tests in CI with GitHub Actions
The GitHub Actions workflow is already set up in the .github/workflows/selenium-tests.yml file to run Selenium tests on every commit.

Generating Allure Reports
After each test execution, Allure Reports are generated. To view the report:

bash
Copy
Edit
mvn allure:report
mvn allure:serve
This will open the Allure report in your browser.

Conclusion
The To-Do List Automation Testing Framework ensures robust testing for core functionalities such as login, registration, adding tasks, and deleting tasks. By leveraging state-independent tests, parallel execution, and continuous integration with GitHub Actions, this framework is designed to provide fast, reliable, and scalable test automation.

The integration of RestAssured for API testing and Allure for advanced reporting makes this framework both dynamic and easy to maintain.

Contributing
We welcome contributions to improve this framework. Feel free to fork the repository, create issues, and submit pull requests.
