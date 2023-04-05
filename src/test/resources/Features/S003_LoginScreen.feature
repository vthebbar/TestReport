Feature: S003_Login screen(before login) features

  Background: 
    Given I m on the login page

  Scenario: S003_TC01_Verify that following fields are displayed in login screen - Username, Password and Login button
    Then Username, Password and Login button are displayed

  Scenario: S003_TC02_Verify that Forgot username/password link is working
    When I click on Forgot username/password link
    Then I m navigated to RESET HLB CONNECT screen
    And Using an Account Number option is displayed with Proceed button
    And Using an ATM Card option is displayed with Proceed button

  Scenario: S003_TC03_Verify that Register for Online Banking option is working
    When I click on Register for Online Banking button
    Then I m navigated to REGISTER FOR ONLINE BANKING screen
    And Using an Account Number option is displayed with Proceed button
    And Using an ATM Card option is displayed with Proceed button

  Scenario: S003_TC04_Verify Terms & Conditions link is working
    When I click on Terms & Conditions link
    Then Terms and conditions are displayed in another new tab

  Scenario: S003_TC05_Verify Privacy Policy link is working
    When I click on Privacy Policy link
    Then Privacy policy displayed in another new tab

  Scenario: S003_TC06_Verify Security Policy link is working
    When I click on Security Policy link
    Then Security Policy displayed in another new tab

  Scenario: S003_TC07_Verify FAQ link is working
    When I click on FAQ link
    Then FAQ displayed in another new tab
