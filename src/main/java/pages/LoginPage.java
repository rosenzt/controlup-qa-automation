package pages;

import Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Logger;

import java.io.IOException;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
    }

    /**
     * Performs a login action using the provided username and password.
     * Populating the respective field and clicks the login button
     *
     * @param username The username to be entered.
     * @param password The password to be entered.
     */
    public void login(String username, String password) {
        Logger.info("Performing login action");
        populateField(LoginPageLocators.USER_NAME_FIELD, username);
        populateField(LoginPageLocators.PASSWORD_FIELD, password);
        click(LoginPageLocators.LOGIN_BUTTON);
    }

    /**
     * Verifies whether the login was successful.
     *
     * @return True if the user is redirected to the inventory page; false otherwise.
     */
    public boolean isLoginSuccessful() {
        String expectedUrl = ConfigReader.getProperty("sauceDemoInventoryUrl");
        boolean loginSuccess = driver.getCurrentUrl().equals(expectedUrl);
        Logger.info("Login success: " + loginSuccess);
        return loginSuccess;
    }
}//Class