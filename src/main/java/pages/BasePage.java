package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 10;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Populates a text field.
     * @param locator - By locator of the field.
     * @param text - Text to input.
     */
    public void populateField(By locator, String text) {
        try {
            WebElement element = waitTillVisible(locator);
            if (element != null) {
                element.clear();
                element.sendKeys(text);
                logger.info("Entered text into: " + locator);
            }
        } catch (Exception e) {
            logger.error("Element not found: " + locator, e);
        }
    }

    /**
     * Clicks a web element.
     * @param locator - By locator of the element.
     */
    public void click(By locator) {
        try {
            WebElement element = waitTillClickable(locator);
            if (element != null) {
                element.click();
                logger.info("Clicked on: " + locator);
            }
        } catch (Exception e) {
            logger.error("Failed to click on: " + locator, e);
        }
    }

    /**
     * Retrieves the text from a web element.
     * @param locator - By locator of the element.
     * @return Text of the element.
     */
    public String getText(By locator) {
        try {
            WebElement element = waitTillVisible(locator);
            return (element != null) ? element.getText() : "";
        } catch (Exception e) {
            logger.error("Failed to get text from: " + locator, e);
            return "";
        }
    }

    /**
     * Waits for an element to be visible.
     * @param locator - By locator of the element.
     * @param timeoutInSeconds - Timeout duration.
     * @return WebElement if found, null otherwise.
     */
    public WebElement waitTillVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            logger.warn("Element not visible after " + timeoutInSeconds + " seconds: " + locator);
            return null;
        }
    }

    /**
     * Overloaded waitTillVisible method using the default timeout.
     *
     * @param locator - By locator of the element.
     * @return WebElement if found, null otherwise.
     */
    public WebElement waitTillVisible(By locator) {
        return waitTillVisible(locator, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for an element to be clickable
     *
     * @param locator - By locator of the element.
     * @param timeoutInSeconds - Timeout duration
     * @return WebElement if found, null otherwise.
     */
    public WebElement waitTillClickable(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            logger.warn("Element not clickable after " + timeoutInSeconds + " seconds: " + locator);
            return null;
        }
    }

    /**
     * Overloading waitTillClickable method using the default timeout.
     *
     * @param locator - By locator of the element.
     * @return WebElement if found, null otherwise.
     */
    public WebElement waitTillClickable(By locator) {
        return waitTillClickable(locator, DEFAULT_TIMEOUT);
    }
}//Class