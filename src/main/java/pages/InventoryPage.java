package pages;

import Locators.InventoryPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) throws IOException {
        super(driver);
    }

    /**
     * Finds the inventory list and added all the items webelements to a list.
     *
     * @return A list of WebElements representing inventory items.
     */
    public List<WebElement> getInventoryItems() {
        List<WebElement> inventoryItems = new ArrayList<>();
        try {
            return driver.findElements(InventoryPageLocators.INVENTORY_ITEMS);
        } catch (NoSuchElementException e) {
            Logger.error("NoSuchElementException - No inventory items found!");
            return Collections.emptyList();
        }
    }

    /**
     * Accepts a int representing the item index required to be added to the cart.
     * Clicks on said item add to cart button.
     *
     * @param itemNumber The index of the item to be added to the cart (starting from 0).
     */
    public void addItemToCart(int itemNumber) {
        List<String> buttonIds = getAllAddToCartButtonIds();

        if (buttonIds.isEmpty()) {
            Logger.error("No 'Add to Cart' buttons found!");
            return;
        }

        if (itemNumber < 0 || itemNumber >= buttonIds.size()) {
            Logger.error("Invalid item index: " + itemNumber);
        }

        try {
            String buttonId = buttonIds.get(itemNumber);
            click(By.id(buttonId));
            Logger.info("Clicked 'Add to Cart' for item with ID: " + buttonId);
        } catch (NoSuchElementException e) {
            Logger.error("Failed to find 'Add to Cart' button with ID: " + buttonIds.get(itemNumber));
        }
    }

    /**
     * Finds the inventory items add to cart buttons.
     * Iterates over the above items list and adds the buttons IDs to new list.
     *
     * @return List of the add to cart ID's webelements
     */
    private List<String> getAllAddToCartButtonIds() {
        List<WebElement> addToCartButtons = driver.findElements(InventoryPageLocators.ADD_TO_CART_BUTTONS);
        if (addToCartButtons.isEmpty()) {
            Logger.warn("No 'Add to Cart' buttons found on the page.");
            return Collections.emptyList();
        }

        List<String> buttonIds = new ArrayList<>();
        for (WebElement button : addToCartButtons) {
            buttonIds.add(button.getAttribute("id"));
        }

        Logger.info("Collected 'Add to Cart' button IDs: " + buttonIds);
        return buttonIds;
    }
}//Class
