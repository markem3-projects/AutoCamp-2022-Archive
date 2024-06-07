Feature: Test

  Scenario: Filters
    Given I have a food name and restaurant page
    When I type in "THAI GREEN CHICKEN CURRY" in browser
    Then "THAI GREEN CHICKEN CURRY" should be displayed