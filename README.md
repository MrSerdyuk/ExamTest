# Selenium Java project created in ITEA

This is a sample project demonstrating how to test Google search UI with Selenium.
Project contains best practices of usage OOP and PageObject/PageFactory patterns for Java/Selenium/TestNG project.

# Usage
GoogleSearchTest has some procedures as follows:
1. Start Chrome(Firefox) and navigate to google.com.
2. Input "selenium"("SELENIUM") in the textbox.
3. Click the search button.
4. Assert the number of Search results is 10 on page 1 and 2.
5. Assert that each result in a list contains searchterm on page 1 and 2.

# How to run tests from this project:

1. Install JDK 1.8 or above corresponding to your OS
2. Install Maven command line utility corresponding to your OS
3. Make sure that following command line commands mvn -version and java -version give you information on mvn and java installed in your OS. Otherwise go back to #1 and #2 and google for proper installation guides.
4. Clone repository with source code via Git
5. In command line to cd to project root folder
6. To run test from command line use following command:
    mvn clean install -DsuiteName=chrome_google_search.xml or -DsuiteName=firefox_google_search.xml
