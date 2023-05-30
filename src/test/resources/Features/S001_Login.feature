Feature: S001_Login

  Scenario Outline: S001_TC01_Login with valid username and valid password
    Given I m on the login page
    When I enter login username "<userName>" and password "<password>"
    And I press on login button
    Then login should be successful

    Examples: 
      | userName | password   |
      | devuat01 | Testing168 |

  Scenario Outline: S001_TC02_Login with invalid username
    Given I m on the login page
    When I enter login username "<userName>" and password "<password>"
    And I press on login button
    Then Error message displayed as "<errMessage>"

    Examples: 
      | userName        | password   | errMessage                              |
      | InvalidUserName | Testing168 | Invalid Login. Please try again. (1009) |

  Scenario Outline: S001_TC03_Login with invalid password
    Given I m on the login page
    When I enter login username "<userName>" and password "<password>"
    And I press on login button
    Then Error message displayed as "<errMessage>"

    Examples: 
      | userName | password        | errMessage                              |
      | devuat01 | InvlaidPassword | Invalid Login. Please try again. (1009) |

  Scenario Outline: S001_TC04_Verify correct error message is displayed when clicked on Login button without entering username and password [Negative]
    Given I m on the login page
    And I press on login button
    Then verify correct error message is displayed for username "<userNameErrMsg>"
    And verify correct error message is displayed for password "<passwordErrMsg>"

    Examples: 
      | userNameErrMsg       | passwordErrMsg       |
      | Username is required | Password is required |
