# Amazon Test Automation Framework in Java

## Purpose
This framework for automated tests is the implementation of a practical programmer assignment to one of the company's tester positions. <br />

#### Untranslated task formulation:
The main steps in the test would be:
1. Starts the selected browser;
2. Going to the selected page (e.g. delfi.lt);
3. Click on the selected link;
4. Check the opened page (for example, check that the page has a specific button or text snippet).

# Composition
[Test suite] master/src/test/java/cases/PurchaseOrderTest.java) 5 test cases are performed:
1. `testLaunchSite ()`: Maximize browser (Chrome) [completed task 1/4 task], load Amazon page [completed task 2/4 task], and if logged in - disconnected [completed by 3/4 task item];
2. `testLogIn ()`: logon to the page by default credentials ([`src / test / java / properties / user.properties`] 
3. `testInitializeShoppingCart ()`: goes to the shopping cart [fulfills task 3/4 task], and if there are goods in it - they are removed; [task 4/4 is completed];
4. `testAddProductToShoppingCart ()`: the selected item ([`src / test / java / enums / Products.java`] (
5. `testVerifyPrices ()`: Checking whether the prices of the product and the shopping cart match 
In the project:
* 11 classes
* 2 enums and
* 1 file with credential
* Also required for logging of the library (the project structure is presented below) (# standard-main% C5% B3-directories% C5% B3-and-file% C5% B3-layout)), these libs are additionally specified and classpaths.

I'm using Maven ([`pom.xml`] (https://github.com) to automate the build (for instructions that requires JDK 8` maven-compiler-plugin`, and 5 add-ons for injection). /apuokenas/amazon-taf-java/blob/master/pom.xml)). Selected in WebDriver, as you can understand from the first test, - ChromeDriver (I successfully used v2.27.440174 and Google Chrome v58.0.3029.81, which is strange because of the homebrew macOS package manager) downloaded ChromeDriver version only supports Chrome v54-56). I programmed in the IntelliJ IDEA environment.

#### Required dependencies artifacts:
* `selenium-java` (you can use the selected Selenium Web Application Testing Framework WebDriver implementation - ChromeDriver, FirefoxDriver or InternetExplorerDriver, there is an alternative to Android and iOS). ,
* `testng` (TestNG testing framework)
* `log4j-api` (the application is programmed for the Log4j 2 API interface);
* `log4j-core` (Log4j 2 implementation required during program execution, but not through compilation)
* `org.osgi.core` (Open Service Gateway Initiative framework for developing a modular program).

## Standard layout for main directories and files
<pre>
/ img - Illustrations of the instructions used in the README file

/ lib - libraries needed for the project

/ src
 | ___ test
      | ___ java - test source
           | ___ actions
           | | | ___ ShoppingActions.java - custom testing methods
           | |
           | ___ base
           | | | ____ LoadProperties.java - load the user.properties file
           | |
           | ___ cases
           | | | ____ PurchaseOrderTest.java - Software Test Scenario with Test Case Steps
           | |
           | ___ enums - the collection of constants
           | | | ____ Products.java - product information with constructor and getter
           | | | |
           | | | ____ Url.java - Required URL links with constructor and getter
           | |
           | ___ pages - web application through its element ID and CSS selector (hence XPath is not used anywhere, 
although it can traverse through the DOM, but the application requires the element ID and the class names were unique),
 representative pages inherited from the parent CommonUtils. class