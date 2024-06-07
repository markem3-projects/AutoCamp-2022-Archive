Feature: Register new user
  Scenario: New user sign up with given credentials
    Given User is on the home page
    When User registers with following data "test9111sssd523", "test98172@gmail.com", "1TreD67@!", "1TreD67@!"
    Then User should be registered successfully as "test9111sssd523"

