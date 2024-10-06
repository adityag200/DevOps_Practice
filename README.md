Project Name: Booker API Automation

Pre-Requisites- Java, TestNG, Maven installed in System

Steps to run the Project in Eclipse:

1. Go to eclipse.
2. Import the project from File System.
3. Ensure pre-requisites are checked.
4. Right click on "testng.xml" and run as testng.suite.
5. Click on extentreport.html to get the report of Passed and Failed Test cases.



Steps to Run the Project on Command Prompt:

We can run using Surefire plugin. In the POM.xml we have mentioned testng.xml file so it will run that file
Open the Terminal and run mvn test