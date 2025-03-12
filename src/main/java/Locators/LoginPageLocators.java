package Locators;

import org.openqa.selenium.By;

/**
 * This class holds locators (By) located on the SauceDemo login page
 */
public class LoginPageLocators {
    public static final By LOG_IN_LOGO = By.className("login_logo");
    public static final By USER_NAME_FIELD = By.id("user-name");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
}//Class