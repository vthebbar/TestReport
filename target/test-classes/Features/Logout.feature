Feature: Logout

  Scenario: Logout after successful login
    Given I m logged in
    When I click on Logout button
    Then I should be loggedout successfully
      | resultMessage                     |
      | You have successfully logged off. |
