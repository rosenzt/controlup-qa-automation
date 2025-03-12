# ControlUp-QA-Automation

## Overview
ControlUp-QA-Automation is an **Automation framework** using **Java, Selenium, and RestAssured**.  
It covers both **UI tests (SauceDemo)** and **API tests (Airport API)**, following the **Page Object Model (POM) and BDD**.

---
## ️ Tech Stack
- **Java 17+**
- **Maven**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **TestNG**
---

## Project Structure
```
ControlUp-QA-Automation/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── locators/                    
│   │   │   │   ├── LoginPageLocators.java  
│   │   │   │   ├── InventoryPageLocators.java  
│   │   │   ├── pages/                       
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── InventoryPage.java
│   │   │   │   ├── BasePage.java
│   │   │   ├── utils/                      
│   │   │   │   ├── Logger.java
│   │   │   │   ├── ConfigReader.java
│   │   │   │   ├── DriverManager.java
│   │   ├── resources/
│   │       ├── config.properties            
│   │       ├── log4j2.xml                   
│   │
│   ├── test/
│   │   ├── java/
│   │   │   ├── runners/                     
│   │   │   │   ├── TestRunner.java
│   │   │   ├── stepdefinitions/            
│   │   │   │   ├── AddItemAndVerifyBadgeTest.java
│   │   │   │   ├── LoginAndVerifyInventoryTest.java
│   │   │   ├── apiSteps/                    
│   │   │   │   ├── CountAndSpecificAirportsTest.java
│   │   │   │   ├── DistanceVerificationTest.java
│   │   │   ├── hooks/                       
│   │   │   │   ├── Hooks.java
│   │   ├── resources/
│   │       ├── features/                    
│   │       │   ├── SauceDemo.feature
│   │       │   ├── AirportAPI.feature
│── pom.xml                                  
│── README.md                               
│── .gitignore                               
```

---

## **Setup Instructions**
### **Clone the Repository**
```sh
git clone https://github.com/your-repo/ControlUp-QA-Automation.git
cd ControlUp-QA-Automation
```

### **Install Dependencies**
```sh
mvn clean install
```

### **Run Tests**
#### **🔹 Run UI Tests**
```sh
mvn test -Dcucumber.filter.tags="@UI"
```
#### **🔹 Run API Tests**
```sh
mvn test -Dcucumber.filter.tags="@API"
```
#### **🔹 Run All Tests**
```sh
mvn test
```

---

## **Reporting**
After running tests, you can find **Cucumber Reports** in:
```sh
target/cucumber-reports.html
```
Open it in a browser to see **detailed execution reports**.

---

