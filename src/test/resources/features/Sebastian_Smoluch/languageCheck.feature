Feature: Changing language

  Scenario: User changes website language and refreshes the page
    Given User is on the home page
    When User changes language to Polish
    Then Subtitle should contain "Wiecej niz pyszne jedzenie"
    When User refreshes the website
    Then Subtitle should contain "Wiecej niz pyszne jedzenie"