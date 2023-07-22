# Selenium-test-Pikaoo

Technologies Used:
Tool: selenium
IDE: IntelIJ
Build tool: Gradle
Language: Java
Framework: TestNG

Prerequisite:
Need to install jdk 1.8
Need good internet connectivity
Run the automation script:
Open cmd to the project folder
Type this command:
gradle clean test
Selenium will open the browser and start automation.



To view report, type this command:
allure generate allure-results --clean -o allure-report
allure serve allure-results
