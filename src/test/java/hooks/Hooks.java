package hooks;

import Locators.LoginPageLocators;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverManager;
import utils.Logger;

import java.time.Duration;

public class Hooks {
    private WebDriver driver;

    /**
     * Sets up the driver before UI tests
     */
    @Before("@UI")
    public void setupUI() {
        Logger.info("Initializing WebDriver for UI tests.");
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("sauceDemoUrl"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.LOG_IN_LOGO));
        Logger.info("Homepage loaded successfully.");
    }

    /**
     * Setting base URI for API tests
     */
    @Before("@API")
    public void setupAPI() {
        Logger.info("Setting up API test environment.");
        RestAssured.baseURI = ConfigReader.getProperty("apiBaseUrl");
    }

    /**
     * Closes the driver after UI tests
     */
    @After("@UI")
    public void tearDownUI() {
        Logger.info("Closing WebDriver.");
        DriverManager.quitDriver();
    }
}//Class