# AspireTest
Aspire_QATest_Cucumber with Selenium in Java

#Project Structure:
1. feature: implement Cucumber feature - write down test scenarios
2. stepDefinition: implement step definition - actions for each step in test scenario (feature file)
3. page: implement page object model - all methods relative to a page/flow
4. object: object model
5. handler: implement selenium code - commom selenium core methods 
6. util: implement utilities helper - utilities that help generate data, constances, save drivers, ...
7. testRunner: config run test with JUnit

#How to run: Using Eclipse
1. Get code from github
2. Update chromedriver path on your device in Browser.java file
Browser.java path: src > test > java > handler > Browser.java: initializeChromeBrowser()
3. Update Maven project to make sure that there're all referenced dependencies
Right click on project's name > Maven > Update Project...
4. Run test
Right click on testrunner.java file > Run As... > JUnit Test
testrunner.java path: src > test > java > testRunner > testrunner.java

