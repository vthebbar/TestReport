Feature: S014_Transfer - Transfer to Own Account

  Background: 
    Given I m logged in

  Scenario: S014_TC01_Verify Transfer To Own Account -Enter Details Section [ USD A/C to USD A/C, Select One time transfer]
    
    [ The Transfer To Own Account screen should show and allow user as below :
    1. Enter Details Page:
    - From: User to be able to select the account to transfer from via drop down
    • To: User to be able to select the account to transfer to via drop down
    • Amount: User to enter amount to transfer (the currency will base on the account to transfer)
    • Equivalent Amount auto pop up 
    • Description: User to enter description of transfer
    • when to Transfer: Use to select either “One time transfer” or Recurring Transfer”
    - One Time Transfer – user to enter date of transfer
    • User to click next
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    Then Verify all fields specified above are displayed

  Scenario: S014_TC02_Verify Transfer To Own Account - Confirm Details section [ USD A/C to USD A/C, Select One time transfer]
    
    [
    In Confirmation details section, user will view the following:
    
    1. One Time Transfer
    • From
    • To
    • Amount (Currency)
    • Exchange Rate
    • Equivalent Amount (Currency)
    • Description
    • when to Transfer {Now}
    • User to click Submit and directed to acknowledgement screen  
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Key in the amount to transfer in Transfer to Own Account - Enter Details section
      | 100 |
    And Key in Description in Transfer to Own Account - Enter Details section
      | OwnAcctTrf |
    And Select One Time Transfer in Transfer to Own Account - Enter Details section
    And Select Date of Transfer in Transfer to Own Account - Enter Details section
      | 12/May/2024 |
    And Click on Next button in Transfer to Own Account - Enter Details section
    Then Verify the fields displayed in Transfer to Own Account - Confirm Details section

  Scenario: S014_TC03_Verify Transfer to Own Account function, acknowledgement screen & Done  button[ USD A/C to USD A/C, Select One time transfer]
    [
    In acknowledgement screen, user will be able to view below:
    • Reference Number
    • Transaction Status (Successful will be green and Failed will be failed)
    • Transaction Date, Time
    • From
    • To
    • Amount (Currency)
    • Exchange Rate
    • Equivalent Amount (Currency)
    • description
    • when to transfer
    . User to able to click done - direct user to main dashbaord
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Key in the amount to transfer in Transfer to Own Account - Enter Details section
      | 10 |
    And Key in Description in Transfer to Own Account - Enter Details section
      | OwnAcctTrf |
    And Select One Time Transfer in Transfer to Own Account - Enter Details section
    And Select Date of Transfer in Transfer to Own Account - Enter Details section
      | 12/Jun/2024 |
    And Click on Next button in Transfer to Own Account - Enter Details section
    And Click on Submit button in Transfer to Own Account - Confirm Details section
    Then Verify the acknowledgement message in Transfer to Own Account - Acknowledgment section
      | You've successfully completed the transfer |
    And Verify Acknowlegdement details are displayed as specified
    And Click on Done button in Transfer to Own Account - Acknowledgment section
    Then I m navigated to home page

  Scenario: S014_TC04_Verify Transfer to Own Account function, acknowledgement screen & Make Another Transfer button [ USD A/C to USD A/C, Select One time transfer]
    [
    In acknowledgement screen, user will be able to view below:
    • Reference Number
    • Transaction Status (Successful will be green and Failed will be failed)
    • Transaction Date, Time
    • From
    • To
    • Amount (Currency)
    • Exchange Rate
    • Equivalent Amount (Currency)
    • description
    • when to transfer
    . user able to click make another transfer - direct user to transfer to own account main screen
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Key in the amount to transfer in Transfer to Own Account - Enter Details section
      | 10 |
    And Key in Description in Transfer to Own Account - Enter Details section
      | OwnAcctTrf |
    And Select One Time Transfer in Transfer to Own Account - Enter Details section
    And Select Date of Transfer in Transfer to Own Account - Enter Details section
      | 2/Jan/2024 |
    And Click on Next button in Transfer to Own Account - Enter Details section
    And Click on Submit button in Transfer to Own Account - Confirm Details section
    Then Verify the acknowledgement message in Transfer to Own Account - Acknowledgment section
      | You've successfully completed the transfer |
    And Verify Acknowlegdement details are displayed as specified
    And Click on Make Another Transfer button in Transfer to Own Account - Acknowledgment section
    Then I m navigated to Transfer to Own Account screen - Enter Details section

  Scenario: S014_TC05_Verify Transfer To Own Account Enter Details Section [Select Recurring Transfer, USD A/C to USD A/C]
    [  The Transfer To Own Account (Recurring) screen should show and allow user as below :
    1. Enter Details Page:
    - From: User to be able to select the account to transfer from via drop down
    • To: User to be able to select the account to transfer to via drop down
    • Amount: User to enter amount to transfer (the currency will base on the account to transfer)
    • Equivalent Amount auto pop up 
    • Description: User to enter description of transfer
    • when to Transfer: Use to select either “One time transfer” or Recurring Transfer”
    - Recurring Transfer – user to enter 
    -> Enter Starting date 
    -> Choose in drop down on repeat frequency
    -> Choose number of times to repeat
    • User to click next ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Select Recurring Transfer radio button
    Then Verify all fields specified above are displayed for recurring transfer

  Scenario: S014_TC06_Verify Transfer To Own Account Confirm Details Section [Select Recurring Transfer, USD A/C to USD A/C]
    [ 
      In ccnfirmation details page, user will view the following:
    1. Recurring transfer
    • From
    • To
    • Amount (Currency)
    • Exchange Rate
    • Equivalent Amount (Currency)
    • Description
    • when to Transfer {Transfer Type}{Start from Date}{Repeat cycle and frequency}{The last transfer Date}
    • User to click next and directed to acknowledement screen 
    
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Key in the amount to transfer in Transfer to Own Account - Enter Details section
      | 10 |
    And Key in Description in Transfer to Own Account - Enter Details section
      | OwnAcctTrfRecurring |
    And Select Recurring Transfer in Transfer to Own Account - Enter Details section
    And Select Starting From date in Transfer to Own Account - Enter Details section
      | 2/Feb/2024 |
    And Select Repeat frequency in Transfer to Own Account - Enter Details section
      | Quarterly |
    And Key in number of times in Transfer to Own Account - Enter Details section
      | 11 |
    And Click on Next button in Transfer to Own Account - Enter Details section
    Then Verify the fields displayed for Recurring Transfer in Transfer to Own Account - Confirm Details section

  Scenario: S014_TC07_Verify Transfer To Own Account Recurring function, Acknowledgement screen & Done button [Select Recurring Transfer, USD A/C to USD A/C]
    [ 
    In acknowledgement screen, user will be able to view below:
    • Reference Number
    • Transaction Status (Successful will be green and Failed will be failed)
    • Transaction Date, Time
    • From
    • To
    • Amount (Currency)
    • Exchange Rate
    • Equivalent Amount (Currency)
    • description
    • when to transfer	
    ->. User to able to click done - direct user to main dashbaord
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Key in the amount to transfer in Transfer to Own Account - Enter Details section
      | 10 |
    And Key in Description in Transfer to Own Account - Enter Details section
      | OwnAcctTrfRecurring |
    And Select Recurring Transfer in Transfer to Own Account - Enter Details section
    And Select Starting From date in Transfer to Own Account - Enter Details section
      | 20/Jun/2024 |
    And Select Repeat frequency in Transfer to Own Account - Enter Details section
      | Quarterly |
    And Key in number of times in Transfer to Own Account - Enter Details section
      | 11 |
    And Click on Next button in Transfer to Own Account - Enter Details section
    And Click on Submit button in Transfer to Own Account - Confirm Details section
    Then Verify the acknowledgement message in Transfer to Own Account - Acknowledgment section
      | You've successfully completed the transfer |
    And Verify Acknowlegdement details are displayed for Recurring Transfer as specified
    And Click on Done button in Transfer to Own Account - Acknowledgment section
    Then I m navigated to home page

  Scenario: S014_TC08_Verify Transfer To Own Account Recurring function, Acknowledgement screen & Make Anotehr Transfer button [Select Recurring Transfer, USD A/C to USD A/C]
    [ 
    In acknowledgement screen, user will be able to view below:
    • Reference Number
    • Transaction Status (Successful will be green and Failed will be failed)
    • Transaction Date, Time
    • From
    • To
    • Amount (Currency)
    • Exchange Rate
    • Equivalent Amount (Currency)
    • description
    • when to transfer	
    ->. user able to click make another transfer - direct user to transfer to own account main screen
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Key in the amount to transfer in Transfer to Own Account - Enter Details section
      | 10 |
    And Key in Description in Transfer to Own Account - Enter Details section
      | OwnAcctTrfRecurring |
    And Select Recurring Transfer in Transfer to Own Account - Enter Details section
    And Select Starting From date in Transfer to Own Account - Enter Details section
      | 02/Jun/2024 |
    And Select Repeat frequency in Transfer to Own Account - Enter Details section
      | Quarterly |
    And Key in number of times in Transfer to Own Account - Enter Details section
      | 11 |
    And Click on Next button in Transfer to Own Account - Enter Details section
    And Click on Submit button in Transfer to Own Account - Confirm Details section
    Then Verify the acknowledgement message in Transfer to Own Account - Acknowledgment section
      | You've successfully completed the transfer |
    And Verify Acknowlegdement details are displayed for Recurring Transfer as specified
    And Click on Make Another Transfer button in Transfer to Own Account - Acknowledgment section
    Then I m navigated to Transfer to Own Account screen - Enter Details section

  Scenario: S014_TC09_Verify Transfer To Own Account without input the amount [Negative test]
    [
      The Transfer To Own Account screen should show user as below:
      - System will show message error "Amount is required"
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Key in Description in Transfer to Own Account - Enter Details section
      | OwnAcctTrf |
    And Select One Time Transfer in Transfer to Own Account - Enter Details section
    And Click on Next button in Transfer to Own Account - Enter Details section
    Then Verify the error message displayed for Amount field in Transfer to Own Account - Enter Details section
      | Amount is required |
	
  Scenario: S014_TC10_Verify Transfer To Own Account without Input the Description [Negative test]
    [
      The Transfer To Own Account screen should show user as below
    - System will show message error  - Description is required
    ]

    When I m navigated to Transfer to Own Account screen
    And Select From account in Transfer to Own Account - Enter Details section
      | 1-01-0001-00006006-3 Current Account (USD)  USD |
    And Select To account in Transfer to Own Account - Enter Details section
      | 2-01-0001-00003800-9 SA USD RESI USD |
    And Key in the amount to transfer in Transfer to Own Account - Enter Details section
      | 10 |
    And Select One Time Transfer in Transfer to Own Account - Enter Details section
    And Click on Next button in Transfer to Own Account - Enter Details section
    Then Verify the error message displayed for Description field in Transfer to Own Account - Enter Details section
      | Description is required |
