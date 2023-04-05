Feature: S001_Login

  Scenario Outline: S001_TC01_Login with valid username and valid password
    Given I m on the login page
    When I enter login username "<userName>" and password "<password>"
    And I press on login button
    Then login should be successful

    Examples: 
      | userName | password   |
      | devuat01 | Testing168 |
