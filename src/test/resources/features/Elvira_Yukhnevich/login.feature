Feature: login
  Verify on entering valid userid and password, the customer can login
  Scenario:Valid login
    Given I am on the Reastaurant website
    When I am logging in as "user0" with "password"
    Then I should be logged in as "user0"