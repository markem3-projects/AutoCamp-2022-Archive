Feature: translate
  Scenario:Verify on translating site after changing language
    Given I am on the Reastaurant website
    When I change language to "Polski"
    Then The description on the website is not in English