**To-Do List Application Automation Testing Framework**
Overview
This project provides a comprehensive Automation Testing Framework for a To-Do List application. The framework is built using Selenium WebDriver, TestNG, and follows best practices such as Page Object Model (POM), data-driven testing, and state-independent testing to ensure reliability and scalability.

Key features:

Login, Register, Add, and Delete Tasks automated tests.
State-independent testing ensuring tests do not depend on user/app state.
Cross-browser support (Chrome, Firefox, Edge, etc.).
Parallel test execution for faster feedback.
Reporting with Allure and screenshots for each test.
GitHub Actions CI/CD integration to run tests in the cloud.
Project Structure
Here’s a breakdown of the project’s structure:
To-Do-List-Automation-Testing/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── todoapp/
│   │               ├── base/                   # Base classes for setup and teardown
│   │               ├── pages/                  # Page Object Model classes (POM)
│   │               ├── tests/                  # Test classes and test scenarios
│   │               ├── utils/                  # Utility classes (e.g., waits, file handling)
│   │               ├── config/                 # Configuration classes (reading from property files)
│   │               └── api/                    # API testing classes (RestAssured integration)
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── todoapp/
│                   ├── tests/                  # TestNG test cases and data-driven tests
│                   └── data/                   # Test data (e.g., JSON, Excel files)
│
├── .gitignore
├── allure-results/                               # Allure report results
├── .github/
│   └── workflows/
│       └── selenium-tests.yml                    # GitHub Actions workflow to run tests on cloud
├── pom.xml                                        # Maven build file (dependencies, plugins)
└── README.md                                      # This README file
Setup & Installation
Prerequisites
Before getting started, make sure you have the following tools installed:

Java 11+
Maven (for dependency management and build automation)
Git
IDE (e.g., IntelliJ IDEA, Eclipse)
WebDriver for browsers (e.g., ChromeDriver, GeckoDriver)
1. Clone the repository:
Clone the repository to your local machine using Git:
git clone https://github.com/your-username/To-Do-List-Automation-Testing.git
cd To-Do-List-Automation-Testing
2. Install dependencies:
Install the required dependencies using Maven:
mvn clean install
3. Configure WebDriver:
Make sure the WebDriver for the browser you want to use (Chrome, Firefox, etc.) is available on your system. You can download the WebDriver from the official browser vendor's site, or you can manage it using a WebDriver manager.
Key Features
1. Page Object Model (POM)
POM Design Pattern is used to organize the test code into different layers for maintainability and scalability.
Base Page Class provides common functionality (e.g., waiting for elements, interacting with UI elements).
Each page of the To-Do List application has its own Page Object class, containing methods to interact with that page’s elements.
2. Driver Management (Driver Holder & Factory)
The framework includes a Driver Factory to create WebDriver instances dynamically.
Driver Holder ensures the driver is shared across tests and cleaned up at the end of each test.
Supports multiple browsers for cross-browser testing (Chrome, Firefox, Edge).
3. Test Data Management
Test data is managed using POJO classes, JSON files, and Excel files.
The tests can be executed with different sets of data using data-driven testing, making the tests more flexible and reusable.
State-independent tests ensure that each test starts with a clean slate. Login and registration are handled within each test, ensuring that the test cases are not dependent on the app’s state.
4. API Testing with RestAssured
RestAssured is integrated to handle API requests for logging in, registering users, and interacting with the To-Do List.
State independence is maintained by ensuring API requests are independent of the UI state, creating and deleting users as needed for each test run.
5. Test Execution
TestNG is used for managing and executing test cases. The framework supports both method-level parallel execution and class-level parallel execution for faster feedback.
Tests can be executed individually or in groups based on methods or classes.
GitHub Actions is integrated to run Selenium tests in the cloud with continuous integration and continuous testing capabilities.
6. Reporting
Allure Reporting provides a rich, detailed report of the test execution.
Screenshots are captured after every test method and included in the Allure report for better debugging.
Test logs are also attached, allowing you to view detailed information about each test.
How to Run the Tests
Running Tests Locally
To run all tests locally using Maven, execute the following command:

bash
Copy
Edit
mvn clean test
This will execute all the test cases configured in the TestNG XML.

Running Tests in Parallel
You can configure parallel execution in TestNG by modifying the testng.xml file. To run tests in parallel, use the following configuration in the XML:
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
his will run the tests concurrently across multiple threads.

Running Tests in CI with GitHub Actions
GitHub Actions is configured to run Selenium tests on every commit.
The workflow file (.github/workflows/selenium-tests.yml) runs the tests in the cloud, ensuring continuous testing on every push to the repository.
Screenshot Capture and Allure Reports
After each test method, a screenshot is taken and attached to the Allure report. The screenshots are stored in the allure-results folder.

To generate the Allure report:
mvn allure:report
mvn allure:serve
**Conclusion**
This To-Do List Automation Testing Framework ensures that all critical functionalities—login, register, add tasks, and delete tasks—are thoroughly tested with state-independent, parallel execution. The integration of RestAssured for API testing and Allure for reporting makes the framework both dynamic and easy to maintain.

This framework is designed for both scalability and reliability, ensuring that tests are repeatable, consistent, and fast—perfect for continuous integration environments.
