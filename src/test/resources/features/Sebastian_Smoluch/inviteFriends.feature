Feature: Invite friends to lunch
  Scenario: User enters data and tries to submit form
    Given User is on book table page, invite friends tab
    When User fills form with following data "7/29/2022, 10:32 AM", "test98172", "test98172@gmail.com", "test@test.pl"
    Then User should be able to click Invite Friends button