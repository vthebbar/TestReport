Feature: S029_Physical & Virtual Card Section, Physical Card Operations

  Background: 
    Given I m logged in
    And I m on Physical & Virtual Card Overview Section

  Scenario: S029_TC01_Verify Physical & Virtual Card screen Overview section
    Then Verify that all labels and submenus are displayed

  Scenario: S029_TC02_Verify Block Physical Card
    When I click on Block/Unblock sub menu for physical card
    And I click on Block button in Block/Unblock Physical Card screen
    Then Card block successful message displayed as below in Block/Unblock Physical Card screen
      | You've successfully blocked your card! You can unblock it anytime you need to |
    And I click on Done button in Block/Unblock Physical Card screen
    Then I m navigated to home page

  Scenario: S029_TC03_Verify UnBlock Physical Card
    When I click on Block/Unblock sub menu for physical card
    And I click on Unblock button in Block/Unblock Physical Card screen
    And I enter the valid TAC in Block/Unblock Physical Card screen
    And I click on Submit button in Block/Unblock Physical Card screen
    Then Card Unblock successful message displayed as below in Block/Unblock Physical Card screen
      | You've successfully unblocked your card! |
    And I click on Done button in Block/Unblock Physical Card screen
    Then I m navigated to home page

  Scenario: S029_TC04_Verify Block E-Commerce - Physical Card
    When I click on Block/Unblock E-commerce sub menu for physical card
    And I click on Block button in Block/Unblock E-Commerce page
    Then Ecommerce blocking successful message displayed in Block/Unblock E-Commerce page
      | You've successfully blocked e-commerce transaction in this debit card with immediate effect |
    And I click on Done button in Block/Unblock E-Commerce page
    Then I m navigated to home page

  Scenario: S029_TC05_Verify Unblock E-Commerce - Physical Card
    When I click on Block/Unblock E-commerce sub menu for physical card
    And I click on Unblock button in Block/Unblock E-Commerce page
    And I enter the valid TAC in Block/Unblock E-Commerce page
    And I click on Submit button in Block/Unblock E-Commerce page
    Then Ecommerce Unblock successful message displayed in Block/Unblock E-Commerce page
      | You've successfully unblocked e-commerce transaction in this debit card with immediate effect |
    And I click on Done button in Block/Unblock E-Commerce page
    Then I m navigated to home page

  Scenario: S029_TC06_Verify Block Overseas ATM/POS - Physical Card
    When I click on Block/Unblock Overseas ATM/POS sub menu for physical card
    And I click on Block button in Block/Unblock Overseas ATM/POS page
    And Verify success message is displayed in Block/Unblock Overseas ATM/POS page
      | You've successfully blocked overseas purchases and withdrawals for your card! |
    And I click on Done button in Block/Unblock Overseas ATM/POS page
    Then I m navigated to home page

  Scenario: S029_TC07_Verify Unblock Overseas ATM/POS - Physical Card
    When I click on Block/Unblock Overseas ATM/POS sub menu for physical card
    And I click on Unblock button in Block/Unblock Overseas ATM/POS page
    And I enter the valid TAC in Block/Unblock Overseas ATM/POS page
    And I click on Submit button in Block/Unblock Overseas ATM/POS page
    Then Verify Unblock success message displayed in Block/Unblock Overseas ATM/POS page
      | You've successfully enabled overseas purchases and withdrawals of your card! |
    And I click on Done button in Block/Unblock Overseas ATM/POS page
    Then I m navigated to home page

  Scenario: S029_TC08_Verify Change Debiting Account screen for Physical Card - Enter Details section
    When I click on Change Debiting Account sub menu for physical card
    Then Verify that Debit Card, Current Debiting Account, New Debiting Account and Next button are displayed

  Scenario: S029_TC09_Verify Change Debiting Account screen for Physical Card confirmation Detail section
    When I click on Change Debiting Account sub menu for physical card
    And I select New Debiting Account from dropdown in Change Debiting Account screen - Enter Details section
    And I click on Next button in Change Debiting Account screen - Enter Details section
    Then Verify that Debit Card, New Debiting Account, HLB Connect Password field, Back and Submit button are displayed

  Scenario: S029_TC10_Verify Change Debiting Account Physical Card confirmation Detail Screen
    When I click on Change Debiting Account sub menu for physical card
    And I select New Debiting Account from dropdown in Change Debiting Account screen - Enter Details section
    And I click on Next button in Change Debiting Account screen - Enter Details section
    And I key in HLB Connect password in Change Debiting Account screen - Confirm Details section
      | Testing168 |
    And I click on Submit button in Change Debiting Account screen - Confirm Details section
    Then Verify that success message is displayed in Change Debiting Account screen - Acknowledgement section
      | You have successfully update the debiting account for your physical debit card. |
    And Verify Debit Account and New Debit Account are displayed in Change Debiting Account screen - Acknowledgement section
    And I click on Done button in Change Debiting Account screen - Acknowledgement section
    Then I m navigated to home page

  @TEST
  Scenario: S029_TC11_Verify Set Daily Limit Screen - Enter Details section
    When I click on Set Daily Limit Submeu for physical card
    Then Verify Debit Card is displayed in Set Daily Limit - Enter Details section
    And Verify labels Transaction Type, Max Daily Limit, Current Daily Limit and New Daily Limit are displayed
    And Verify Purchase Limit label and values are displayed in Set Daily Limit Screen - Enter Details section
    And Verify Withdrawal Limit label and values are displayed in Set Daily Limit Screen - Enter Details section

  #Scenario: S029_TC12_Verify Set Daily Limit with invalid new limit for Purchase Limit less than 5
#
  #Scenario: S029_TC13_Verify Set Daily Limit with invalid new limit for Purchase Limit more than 100000
  #
  #
   #Scenario: S029_TC14_Verify Set Daily Limit with invalid new limit for Withdrawal Limit less than 5
#
  #Scenario: S029_TC15_Verify Set Daily Limit with invalid new limit for Withdrawal Limit more than 100000
