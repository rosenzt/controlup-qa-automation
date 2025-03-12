package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Utility class for managing the WebDriver instance.
 * Uses WebDriverManager to set up ChromeDriver.
 */
public class DriverManager {
    private static WebDriver driver;

    /**
     * Retrieves a singleton instance of WebDriver.
     * If no WebDriver instance exists, it initializes ChromeDriver.
     *
     * @return A WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * Quits the WebDriver instance and releases resources.
     * Sets the driver instance to null.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
