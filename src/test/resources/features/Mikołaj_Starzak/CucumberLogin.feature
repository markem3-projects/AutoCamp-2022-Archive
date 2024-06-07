Feature: Test

  Scenario: Login
    Given I have a username, password and a login page open
    When I write my username "user0" and password "password" in login page and then confirm
    Then I should be logged in as "user0"