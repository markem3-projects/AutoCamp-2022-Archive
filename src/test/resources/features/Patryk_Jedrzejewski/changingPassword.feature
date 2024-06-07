Feature: changingPassword
  Verify on changing password, the customer can login with new password
  Scenario:Valid changing password
    Given I am on the Restaurant website and I am logging in as "user0" with "password"
    When I am changing password from "password" to "123" and I am logging out
    Then I should log in using new password: "123" and I should be logged in as "user0"