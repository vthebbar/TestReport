Feature: Login

  Scenario Outline: Login with valid username and valid password
    Given I m on the login page
    When I enter login username "<userName>" and password "<password>"
    And I press on login button
    Then login should be successful

    Examples: 
      | userName   | password   |
      | connect112 | Connect321 |
