Feature: Login as registered user
  Scenario: User sign in with correct login credentials
    Given User is on the home page
    When User sign in as "user0" with password "password"
    Then User should be logged in as "user0"
