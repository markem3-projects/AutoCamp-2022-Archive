Feature: lowerEqualPriceFiltering
  Verify on setting slider at specific value, items below and equal do this value are displayed
  Scenario:Valid lower equal price filtering
    Given I am on the Restaurant website, I go to Menu and change resolution of screen at 1368x770
    When I expand filters and set price slider at -275 horizontally and 0 vertically
    Then "TEA" should be displayed