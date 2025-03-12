package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;
import utils.Logger;

import java.io.IOException;

/**
 * UI test - This class covers a login action and verifies the number of items displayed on the inventory page
 *
 * This test:
 * - Logs in using provided credentials.
 * - Verifies number of items on the inventory page
 */
public class LoginAndVerifyInventoryTest {
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;

    public LoginAndVerifyInventoryTest() throws IOException {
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        Logger.info("Opening login page");
        String expectedUrl = ConfigReader.getProperty("sauceDemoUrl");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Expected landing page not found, expected: "
                + expectedUrl + ", actual: " + actualUrl);
    }

    @When("User successfully logs in with valid credentials")
    public void userSuccessfullyLogsInWithValidCredentials() {
        Logger.info("Testing login action");
        String expectedUrl = ConfigReader.getProperty("sauceDemoInventoryUrl");
        String actualUrl = driver.getCurrentUrl();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed, expected URL: " + expectedUrl + ", actual: " + actualUrl);
    }

    @Then("Inventory page should display exactly {int} items")
    public void inventoryPageShouldDisplayExactly6Items(int expectedNumberOfItems) {
        Logger.info("Testing inventory size");
        int actualNumberOfItems = inventoryPage.getInventoryItems().size();
        Assert.assertEquals(actualNumberOfItems, expectedNumberOfItems,
                "Wrong number of items found, expected " + expectedNumberOfItems + "found: " + actualNumberOfItems);
    }
}//Class