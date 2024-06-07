Feature: Sorting dishes by price
  Scenario: User wants to sort dishes by price ascending
    Given User is on menu page
    When User sorts dishes ascending
    Then Dishes should be displayed in correct order
