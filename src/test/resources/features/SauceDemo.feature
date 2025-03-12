@UI
Feature: Inventory and Cart Management

  Scenario: Login and verify number of inventory Items
    Given User is on the login page
    When User successfully logs in with valid credentials
    Then Inventory page should display exactly 6 items

  Scenario: Add First Item to Cart and verify cart badge
    Given User is successfully logged in
    When User adds the first inventory item to the cart
    Then The cart badge should display 1