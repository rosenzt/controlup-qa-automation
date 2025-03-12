package Locators;

import org.openqa.selenium.By;

/**
 * This class holds locators (By) located on SauceDemo inventory page
 */
public class InventoryPageLocators {
    public static final By INVENTORY_ITEMS = By.cssSelector(".inventory_list > .inventory_item");
    public static final By ADD_TO_CART_BUTTONS = By.cssSelector("button[data-test^='add-to-cart']");
    public static final By SHOPPING_CART_BADGE = By.cssSelector(".shopping_cart_badge");
}
