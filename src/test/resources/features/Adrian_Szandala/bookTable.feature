Feature: Test book table functionality

  Scenario:Validate book table with correct data
    Given User open book table page
    When User enters date "8/14/2022, 12:12 PM", name "Adrian",email "2@wp.pl", table guests "3"
    And Click on Accept terms
    And Click on BOOK TABLE
    When Click SEND button
    Then Table should be succesfully booked

  Scenario:Validate book table with incorrect data
    Given User open book table page
    When User enters date "8/14/2022, 12:12 PM", name "Adrian",email "2@wp.pl", table guests "3.5"
    And Click on Accept terms
    And Click on BOOK TABLE
    When Click SEND button
    Then Booking table shouldn't be possible
