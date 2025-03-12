package stepdefinitions;

import Locators.InventoryPageLocators;
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
 * UI Test: Adds the first item to the cart and verifies that the cart badge displays "1".
 * <p>
 * This test:
 * - Logs in using provided credentials.
 * - Adds the first item from the inventory to the cart.
 * - Validates that the shopping cart badge updates correctly.
 */
public class AddItemAndVerifyBadgeTest {
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;

    public AddItemAndVerifyBadgeTest() throws IOException {
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
    }

    @Given("User is successfully logged in")
    public void userIsSuccessfulLogin() {
        Logger.info("Testing login action");
        String expectedUrl = ConfigReader.getProperty("sauceDemoInventoryUrl");
        String actualUrl = driver.getCurrentUrl();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed, expected URL: " + expectedUrl + ", actual: " + actualUrl);
    }

    @When("User adds the first inventory item to the cart")
    public void userAddsTheXInventoryItemToTheCart() {
        Logger.info("Testing adding the first inventory item to the cart");
        inventoryPage.addItemToCart(0);
    }

    @Then("The cart badge should display 1")
    public void theCartBadgeShouldDisplayX() {
        Logger.info("Verifing the cart badge text");
        String numberOfItemsOnBagdge = inventoryPage.getText(InventoryPageLocators.SHOPPING_CART_BADGE);
        Assert.assertEquals(numberOfItemsOnBagdge, "1",
                "Incorrect number of items in shopping cart, expected 1, found: " + numberOfItemsOnBagdge);
    }
}//Class