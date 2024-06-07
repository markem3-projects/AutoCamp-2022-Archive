Feature: invite
  Verify on inviting friends for logged in customer
  Scenario:Verify on inviting friends
    Given I am on the Reastaurant website
    When I invite with date "7/22/2022, 1:17 PM", name "Elvira", email "qwert@q.ru", invitationEmail = "asdfg@we.ru"
    Then I invited