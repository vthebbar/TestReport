Feature: S025_ Esaver feature - Personalize Account

  Background: 
    Given I m logged in
    And I m navigated to E-Saver Personalize Account screen

  Scenario: S025_TC01_Verify Personalize Account screen
    [
      The Personalize Account screen should as below:
      1. Users to be able to select the Account via dropdown
      2. Current Account Name 
      3. Use to be able to key in the New Account Name then click next
    ]

    Then Above specified fields are displayed in Personalize Account screen

  Scenario Outline: S025_TC02_Verify Personalize Account without input the New Account Name [Negative test]
    [
       The Personalize Account screen should show and allow user as below
      - System will show message error "New Account Name is required"
    ]

    When I select account number "<accountNumVal>" from dropdown in Personalize Account - Enter Details section
    And I click on Next button in Personalize Account - Enter Details section
    Then Error message is displayed in Personalize Account - Enter Details section
      | New Account Name is required |

    Examples: 
      | accountNumVal |
      |         10008 |
	
  Scenario Outline: S025_TC03_Verify Personalize Account Acknowledgement screen
    [
      The Personalize Account Acknowledgement screen should show user as below
      1. Account information
      2. Old Account Name information
      3. New Account Name information and Done button
      4. Message show "You've successfully updated your E-Saver account."
      5. clikcing done will go back to main dashboard
      
    ]

    When I select account number "<accountNumVal>" from dropdown in Personalize Account - Enter Details section
    And I key in New Account Name "<newAcctName>" in Personalize Account - Enter Details section
    And I click on Next button in Personalize Account - Enter Details section
    Then Verify success message is displayed in Personalize Account -Acknowledgement section
    |You've successfully updated your E-Saver account.|
    And Verify acknowledgement details in Personalize Account -Acknowledgement section
    And I click on Done button in Personalize Account -Acknowledgement section
    Then I m navigated to home page

    Examples: 
      | accountNumVal | newAcctName |
      |         10008 | myEsaver    |
