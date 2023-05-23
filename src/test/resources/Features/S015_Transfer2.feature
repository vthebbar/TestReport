Feature: S015_Transfer - Transfer to Other Account at HLBCAM

  Background: 
    Given I m logged in

  Scenario: S015_TC01_Verify Transfer to Other Account at HLBCAM - Transfer Details entry section [ one time transfer, from USD Account ]
    
    [
    The Transfer to Other Account at HLBCAM screen should show and allow user as below:
    1. User to be able to select the account to transfer from via drop down
    2. User to enter the account to transfer 
    3. User to enter amount to transfer (the currency will base on account to transfer from)
    4. Equivalent Amount auto pop up 
    5. User to enter description of transfer
    6. Use to select either “One time transfer” or Recurring Transfer”
       - One Time Transfer – user to enter date of transfer
    7. User to enter the phone number if user wants to Send SMS Notification (Optional) 
    8. Next button
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    Then Verify all fields are displayed in Transfer to Other Account at HLBCAM - Details entry section

  Scenario: S015_TC02_Verify Transfer to Other Account at HLBCAM - Transfer Details Confirmation screen [ one time transfer, from USD A/C to USD A/C ]
    
    [
    The Transfer to Other Account at HLBCAM Confirmation screen should show and allow user as below
    1. From account 
    2. Recipient Bank 
    3. Recipient account number
    3. Recipient Name
    4. Favourite Account Name (If user chooses to transfer to favourite, if not favourite this field will not appear)
    5. Amount information (Currency)
    6. Exchange Rate (%)
    7. Equivalent Amount (Currency)
    8. Description 
    9. when to Transfer: 
    - One Time Transfer (Now)
    10. User to key in TAC 
    11. User to click Submit and directed to success screen
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in To Account in Transfer to Other Account at HLBCAM - Details entry section
      | 1010001000058932 |
    And Key in Amount and Description in Transfer to Other Account at HLBCAM - Details entry section
      |                  10 |
      | USD to USD one time |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | One Time Transfer |
    And Select the Date in Transfer to Other Account at HLBCAM - Details entry section
      | 10/May/2023 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    Then Verify Transfer to Other Account at HLBCAM screen - Confirmation  section

  Scenario: S015_TC03_Verify Transfer to Other Account at HLBCAM Acknowledgement(success) screen and Click Done button
    [       [One Time Transfer, USD A/C to USD A/C]
    		
     	 The Transfer to Other Account at HLBCAM Success screen should show and allow user as below
     	 Green ribbon with  "You've successfully completed the transfer"
      1. Reference Number
      2. Transaction Status
      3. Transaction Date,Time
      4. From account 
      5. Recipient Bank 
      6. Recipient account number
      7. Recipient Name
      8. Favourite Account Name (If user chooses to transfer to favourite, if not favourite this field will not appear)
      9. Amount (Currency)
      10. Exchange Rate (%)
      11. Equivalent Amount (Currency)
      12. Description 
      13. Balance after transfer
     			 when to Transfer:  (Now)
    
      15. User able to click Done to direct to main dashboard
      
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in To Account in Transfer to Other Account at HLBCAM - Details entry section
      | 1010001000058932 |
    And Key in Amount and Description in Transfer to Other Account at HLBCAM - Details entry section
      |                  10 |
      | USD to USD one time |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | One Time Transfer |
    And Select the Date in Transfer to Other Account at HLBCAM - Details entry section
      | 10/May/2023 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    And I click on Submit button in Transfer to Other Account at HLBCAM screen - Confirmation  section
    Then Verify message in Transfer to Other Account at HLBCAM - Acknowledgement section
      | You've successfully completed the transfer |
    And Verify fields are displayed correctly in Transfer to Other Account at HLBCAM - Acknowledgement section
    And I click on Done button in Transfer to Other Account at HLBCAM - Acknowledgement section
    Then I m navigated to home page

  Scenario: S015_TC04_Verify Transfer to Other Account at HLBCAM Acknowledgement(success) screen and Click Make Another Transfer button
    [       [One Time Transfer, USD A/C to USD A/C]
    
     The Transfer to Other Account at HLBCAM Success screen should show and allow user as below
     Green ribbon with  "You've successfully completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient account number
    7. Recipient Name
    8. Favourite Account Name (If user chooses to transfer to favourite, if not favourite this field will not appear)
    9. Amount (Currency)
    10. Exchange Rate (%)
    11. Equivalent Amount (Currency)
    12. Description 
    13. Balance after transfer
    		 when to Transfer:  (Now)
    14. User able to click make another transfer to direct back to HLBCAM Transfer main screen
    
    
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in To Account in Transfer to Other Account at HLBCAM - Details entry section
      | 1010001000058932 |
    And Key in Amount and Description in Transfer to Other Account at HLBCAM - Details entry section
      |                  10 |
      | USD to USD one time |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | One Time Transfer |
    And Select the Date in Transfer to Other Account at HLBCAM - Details entry section
      | 10/May/2023 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    And I click on Submit button in Transfer to Other Account at HLBCAM screen - Confirmation  section
    Then Verify message in Transfer to Other Account at HLBCAM - Acknowledgement section
      | You've successfully completed the transfer |
    And Verify fields are displayed correctly in Transfer to Other Account at HLBCAM - Acknowledgement section
    And I click on Make Another Transfer button in Transfer to Other Account at HLBCAM - Acknowledgement section
    Then I m navigated to Transfer to Other Account at HLBCAM main screen

  Scenario: S015_TC05_Verify Transfer to Other Account at HLBCAM - Details Entry section [Recurring Transfer, USD to USD A/C]
    [
    The Transfer to Other Account at HLBCAM screen should show and allow user as below
    1. User to be able to select the account to transfer from via drop down
    2. User to enter the account to transfer 
    3. User to enter amount to transfer (the currency will base on account to transfer from)
    4. Equivalent Amount auto pop up 
    5. User to enter description of transfer
    6. Use to select either “One time transfer” or Recurring Transfer”
      - Recurring Transfer – user to enter 
        - Enter Starting date 
        - Choose in drop down on repeat frequency
       - Choose number of times to repeat
    7. User to enter the phone number if user wants to Send SMS Notification (Optional) 
    8. click User to click next
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | Recurring Transfer |
    Then Verify all fields are displayed in Transfer to Other Account at HLBCAM - Details entry section - Recurring Transfer

  Scenario: S015_TC06_Verify Transfer to Other Account at HLBCAM - Transfer Details Confirmation screen [ Recurring transfer, from USD A/C to USD A/C ]
    [
     The Transfer to Other Account at HLBCAM Confirmation screen should show and allow user as below
    1. From account 
    2. Recipient Bank 
    3. Recipient account number
    3. Recipient Name
    4. Favourite Account Name (If user chooses to transfer to favourite, if not favourite this field will not appear)
    5. Amount information (Currency)
    6. Exchange Rate (%)
    7. Equivalent Amount (Currency)
    8. Description 
    9. when to Transfer: {Transfer Type}{Start from Date}{Repeat cycle and frequency}{The last transfer Date}
    10. User to key in TAC 
    11. User to click Submit and directed to success screen
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in To Account in Transfer to Other Account at HLBCAM - Details entry section
      | 1010001000058932 |
    And Key in Amount and Description in Transfer to Other Account at HLBCAM - Details entry section
      |                  10 |
      | USD to USD one time |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | Recurring Transfer |
    And Select the Starting From Date, Repeat frequency and number of times in Transfer to Other Account at HLBCAM - Details entry section
      | 10/Dec/2023 |
      | Quarterly   |
      |           4 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    Then Verify Transfer to Other Account at HLBCAM screen - Confirmation  section - Recurring Transfer

  Scenario: S015_TC07_Verify Transfer to Other Account at HLBCAM Acknowledgement(success) screen and Click Done button
    			 [  Recurring Transfer, USD A/C to USD A/C   ]
    [
           The Transfer to Other Account at HLBCAM Success screen should show and allow user as below
         green ribbon with copy "You've successfuly completed the transfer"
        1. Reference Number
        2. Transaction Status
        3. Transaction Date,Time
        4. From account 
        5. Recipient Bank 
        6. Recipient account number
        7. Recipient Name
        8. Favourite Account Name (If user chooses to transfer to favourite, if not favourite this field will not appear)
        9. Amount (Currency)
        10. Exchange Rate (%)
        11. Equivalent Amount (Currency)
        12. Description 
        13. Balance after transfer
            - when to Transfer:  {Transfer Type}{Start from Date}{Repeat cycle and frequency}{The last transfer Date}
        15. User able to click Done to direct to main dashboard
            		
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in To Account in Transfer to Other Account at HLBCAM - Details entry section
      | 1010001000058932 |
    And Key in Amount and Description in Transfer to Other Account at HLBCAM - Details entry section
      |                  10 |
      | USD to USD one time |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | Recurring Transfer |
    And Select the Starting From Date, Repeat frequency and number of times in Transfer to Other Account at HLBCAM - Details entry section
      | 10/Dec/2023 |
      | Quarterly   |
      |           4 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    And I click on Submit button in Transfer to Other Account at HLBCAM screen - Confirmation  section
    Then Verify message in Transfer to Other Account at HLBCAM - Acknowledgement section
      | You've successfully completed the transfer |
    And Verify fields are displayed correctly in Transfer to Other Account at HLBCAM - Acknowledgement section
    And I click on Done button in Transfer to Other Account at HLBCAM - Acknowledgement section
    Then I m navigated to home page

  Scenario: S015_TC08_Verify Transfer to Other Account at HLBCAM Acknowledgement(success) screen and Click Make Another Transfer button
     [  Recurring Transfer, USD A/C to USD A/C   ]
    [
       The Transfer to Other Account at HLBCAM Success screen should show and allow user as below
       green ribbon with copy "You've successfuly completed the transfer"
       1. Reference Number
       2. Transaction Status
       3. Transaction Date,Time
       4. From account 
       5. Recipient Bank 
       6. Recipient account number
       7. Recipient Name
       8. Favourite Account Name (If user chooses to transfer to favourite, if not favourite this field will not appear)
       9. Amount (Currency)
       10. Exchange Rate (%)
       11. Equivalent Amount (Currency)
       12. Description 
       13. Balance after transfer
       			-when to Transfer:  {Transfer Type}{Start from Date}{Repeat cycle and frequency}{The last transfer Date}
       14. User able to click Make Another Transfer to direct back to HLBCAM Transfer main screen 		
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in To Account in Transfer to Other Account at HLBCAM - Details entry section
      | 1010001000058932 |
    And Key in Amount and Description in Transfer to Other Account at HLBCAM - Details entry section
      |                  10 |
      | USD to USD one time |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | Recurring Transfer |
    And Select the Starting From Date, Repeat frequency and number of times in Transfer to Other Account at HLBCAM - Details entry section
      | 10/Dec/2023 |
      | Quarterly   |
      |           4 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    And I click on Submit button in Transfer to Other Account at HLBCAM screen - Confirmation  section
    Then Verify message in Transfer to Other Account at HLBCAM - Acknowledgement section
      | You've successfully completed the transfer |
    And Verify fields are displayed correctly in Transfer to Other Account at HLBCAM - Acknowledgement section
    And I click on Make Another Transfer button in Transfer to Other Account at HLBCAM - Acknowledgement section
    Then I m navigated to Transfer to Other Account at HLBCAM main screen

  Scenario: S015_TC09_Verify Transfer to Other Account at HLBCAM without input To Account [Negative test]
    
    [  
    	Key in all fields , except To Account, Click Next button
      The Transfer to Other Account at HLBCAM screen should show user as below
    	 - System will show message error "Please input the Account number"
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in Amount and Description in Transfer to Other Account at HLBCAM - Details entry section
      |                  10 |
      | USD to USD one time |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | One Time Transfer |
    And Select the Date in Transfer to Other Account at HLBCAM - Details entry section
      | 31/Dec/2023 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    Then Verify the error message for To Account field in Transfer to Other Account at HLBCAM - Details entry section
      | To Account is required |

  Scenario: S015_TC10_Verify Transfer to Other Account at HLBCAM without input the Amount [Negative test]
    
    [
    	->fill in all field, exclude the Amount and click Next button 
    The Transfer to Other Account at HLBCAM screen should show user as below
    - System will show message error "Please input the Amount"
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in To Account in Transfer to Other Account at HLBCAM - Details entry section
      | 1010001000058932 |
    And Key in Description in Transfer to Other Account at HLBCAM - Details entry section
      | USD to USD one time |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | One Time Transfer |
    And Select the Date in Transfer to Other Account at HLBCAM - Details entry section
      | 31/Dec/2023 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    Then Verify the error message for Amount field in Transfer to Other Account at HLBCAM - Details entry section
      | Amount is required |

  Scenario: S015_TC11_Verify Transfer to Other Account at HLBCAM without input the Decription [Negative test]
    
    [
    ->fill in all field, exclude the Decription and click Next button 
    The Transfer to Other Account at HLBCAM screen should show user as below
    - System will show message error "Please input the Amount"
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And Select From account in Transfer to Other Account at HLBCAM - Details entry section
      | 10001 |
    And Key in To Account in Transfer to Other Account at HLBCAM - Details entry section
      | 1010001000058932 |
    And Key in Amount in Transfer to Other Account at HLBCAM - Details entry section
      | 10 |
    And Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section
      | One Time Transfer |
    And Select the Date in Transfer to Other Account at HLBCAM - Details entry section
      | 31/Dec/2023 |
    And Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section
      | 12345679 |
    And Click on Next button in Transfer to Other Account at HLBCAM - Details entry section
    Then Verify the error message for Description field in Transfer to Other Account at HLBCAM - Details entry section
      | Description is required |
	
	
  Scenario: S015_TC12_Verify Add  Favourites function, Click Yes, Click Done button [Under Transfer to Other Account at HLBCAM]
    [
    
    Adding Favourite account:
    1.  User to click on Add Favourite
    2. Pop-up will be prompted with copy "You will be directed to another page and will be exiting this transfer transaction. Would you like to proceed?"
    3. if user clicks "Yes", user will be directed to "manage favourite accounts" first
    4. Key in All details & submit
    5. Once Acknowledgement is displayed, click on Done button -> should navigate to main Home page
    
    ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And I click on Add Favourite menu in Transfer to Other Account at HLBCAM - Details entry section
    And I click on Yes button in pop up at Transfer to Other Account at HLBCAM - Details entry section
    And Select the Transaction Type in Manage My Favourite Accounts screen
      | Transfer to Other Accounts at HLBCAM |
    And Key in the Favourite Account details in Manage My Favoutite Accounts screen
      | ReceipientBankAddress | ToAccount        | FavouriteAccountName |
      | Cambodia              | 1010001000058932 | MyFavHLBCAM          |
    And Click on Next button in Manage Favoutite Accounts screen
    And Key in the TAC in Manage Favourite Accounts-Receipient information section
    And Click on Submit button in Manage Favourite Accounts-Receipient information section
    Then Verify message in Manage Favoutite Accounts - Acknowledgement section
      | Added a favourite payee |
    And Verify all details are displayed correctly in Manage Favoutite Accounts - Acknowledgement section
    And Click on Done button in Manage Favourite Accounts - Acknowledgement section
    Then I m navigated to home page

  Scenario: S015_TC13_Verify Add  Favourites function, Click No [Under Transfer to Other Account at HLBCAM]
     [
     
      Adding Favourite account:
      1.  User to click on Add Favourite
      2. Pop-up will be prompted with copy - You will be directed to another page and will be exiting this transfer transaction. 
      																				Would you like to proceed?
      4. if user clicks "No", user will go back to transfer to Other HLBCAM account screen
      
      ]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And I click on Add Favourite menu in Transfer to Other Account at HLBCAM - Details entry section
    And I click on No button in pop up at Transfer to Other Account at HLBCAM - Details entry section
    Then I m navigated to Transfer to Other Account at HLBCAM main screen
	
	
  Scenario: S015_TC14_Verify Favourites accounts will be on the left where user has option to add and delete favourite
    [Under Transfer to Other Account at HLBCAM]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    Then Add Favourite menu and Delete or Bin icon button are displayed in Transfer to Other Account at HLBCAM - Details entry section
	
	
  Scenario: S015_TC15_Verify Delete Favourite Account functionality [Under Transfer to Other Account at HLBCAM]
    [ Verify able to delete favourite]

    When I m navigated to Transfer to Other Account at HLBCAM - Details entry section
    And I click on Delete or Bin icon button in Transfer to Other Account at HLBCAM - Details entry section
    And I click on Checkbox to selet the record for deletion in Transfer to Other Account at HLBCAM - Details entry section
    And I click on Yes button in Transfer to Other Account at HLBCAM - Details entry section - pop up to confirm the deletion
    Then Favourite Record deleted successfully
