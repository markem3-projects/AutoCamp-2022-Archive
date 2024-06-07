Feature: Link to Devonfw
  Scenario: User wants to open Devonfw page
    Given User is on the home page
    When User clicks devonfw link
    Then User should be navigated to "http://devonfw.com/"