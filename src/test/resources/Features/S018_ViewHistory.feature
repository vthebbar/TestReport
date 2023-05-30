Feature: S018_View History (Under Pay & Transact -> Online Transactions )

  Background: 
    Given I m logged in
    And I m navigated to View History screen

  Scenario: S018_TC01_Verify dropdown options and serach button are available for filetring
    [
     	 The View History screen should shows below:
      
       o Account
       o Transaction Type
       o Status
       o Period
       o Search button
    
    ]

    Then Verify dropdown options for Account, Transaction Type, Status and Period are displayed in View History screen
    And Verify Search button is displayed in View History screen

  Scenario: S018_TC02_Verify able to download CSV file for this history
    When I click on Download CSV link in View History screen
    Then Verify that CSV file is downloaded

  
  Scenario: S018_TC03_Verify Transaction History table headers(View History field details)
    [
      	Verify below fields are displayed
      - REF NO
      - Date
      - FROM
      - TO ACCOUNT
      - TRANSACTION TYPE
      - AMOUNT
      - STATUS
      - ACTIONS
    
    ]

    Then Verify View History table headers are dispalyed in View History screen
	
	
  Scenario: S018_TC04_Verify Transaction Details by Clicking on REF NO. link
    [
     User to click on the Ref No. and User will be directed to transaction details screen. User will be able to view:
    - transaction status
    - Transaction date,time
    - From
    - To
    - Amount (Currency)
    - Transaction Type  
    - Back button
    - Repeat button
    ]

    And I click on REF NO. link in View History screen
    Then Verify all transaction details mentioned above are displayed in trsanction details screen
    And Back and Repeat button are displayed in trsanction details screen

	
  Scenario: S018_TC05_Verify Repeat button functionality in View History screen [Repeat Overseas Transfer]
    And I search for Overseas Transfer Transaction Type
    |Overseas Transfer|
    And I click on Repeat button in View History screen
    And I Key in Amount in Overseas Transfer - Details Entry Section
      | 111 |
    And I click on Next button in Overseas Transfer - Details Entry Section
    And I key in TAC in Overseas Transfer - Confirmation Section
    And I click on Submit button in Overseas Transfer - Confirmation Section
    Then Verify transaction success message in Overseas Transfer - Acknowledgement Section
      | Your transfer request has been successful and will now be processed |
	
	
  Scenario: S018_TC06_Verify Repeat button functionality in Transaction Details screen [Repeat Local Transfer]
    And I search for Local Transfer Transaction Type in View History screen
    |Local Transfer|
    And I click on REF NO. link in View History screen
    And I click on Repeat button in Transaction Details screen
    And I Key in Amount in Local Transfer - Details Entry Section
      | 11 |
    And I click on Next button in Local Transfer - Details Entry Section
    And I click on Submit button in Local Transfer - Confirmation Section
    Then Verify transaction success message in Local Transfer - Acknowledgement Section
      | You've successfully completed the transfer |
	
	
  Scenario: S018_TC07_Verify Back button in Transaction History screen
    And I click on REF NO. link in View History screen
    And I click on Back button in Transaction Details screen
    Then I m directed back to View History page
