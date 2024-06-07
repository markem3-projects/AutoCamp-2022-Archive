Feature: Test

  Scenario: Basket
    Given I'm on a main page
    When I order first food item i see using my booking id "123"
    Then I should get a confirmation message "Order complete"