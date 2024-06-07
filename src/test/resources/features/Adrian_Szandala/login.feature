Feature: Test login functionality

  Scenario:Validate login
    Given User open login page
    When User enters username "u12s13!A" and password "u12s13!A"
    And Click on login button
    Then User should be login as "u12s13!A"
