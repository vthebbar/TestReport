Feature: S016_Transfer - Local Transfer

  Background: 
    Given I m logged in

  Scenario Outline: S016_TC01_Verify Local Transfer Details Entry section elements are displayed [One Time Transfer, from USD account]
    
    [
    The Local Transfer screen should show and allow user as below
    1. User to be able to select the account to transfer from via drop down
    2. User to select recipient bank via drop down
    3. User to enter the recipient account number
    4. User to enter recipient name
    5. User to enter amount to transfer (the currency will base on sender account)
    6. User to enter description of transfer
    7. Use to select either “One time transfer” or Recurring Transfer”
    - One Time Transfer – user to enter date of transfer
    8. User to enter the phone number if user wants to Send SMS Notification (Optional) 
    9. click User to click next
    
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select from account "<FromAcct>" in Local Transfer - Details Entry Section
    Then Verify all elements are displayed in Local Transfer - Details Entry Section

    Examples: 
      | FromAcct |
      |    10001 |

  Scenario Outline: S016_TC02_Verify Local Transfer Confirmation screen [One Time Transfer, from USD account]
    [
    				The Local Transfer Success screen should show and allow user as below
    		Green ribbon with copy "You've successfuly completed the transfer"
    		1. Reference Number
    		2. Transaction Status
    		3. Transaction Date,Time
    		4. From account 
    		5. Recipient Bank 
    		6. Recipient account number
    		7. Recipient Name
    		8. Amount (Currency)
    		9. Description 
    		10.when to Transfer:  (Now)
    		11. User able to click make another transfer to direct back to Local Transfer main screen
    		12. User able to click Done to direct to main dashboard
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer "<ToAcct>", "<ReceipientName>", "<Amount>", "<Description>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I click on Next button in Local Transfer - Details Entry Section
    Then Verify that all details displayed correctly in Local Transfer - Confirmation Section

    Examples: 
      | FromAcct | ReceipientBank   | ToAcct    | ReceipientName  | Amount | Description   | SMSMobileNo | whenToTransfer    | Date  |
      |    10001 | AAA Bank Limited | 000570581 | LocalReceipient |  10.10 | LocalTransfer |   123456790 | One Time Transfer | Today |

  Scenario Outline: S016_TC03_Verify Local Transfer function, Success screen and Click on Make Another Transfer [One Time Transfer, from USD account]
    [
    The Local Transfer Success screen should show and allow user as below
    Green ribbon with copy "You've successfully completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient account number
    7. Recipient Name
    8. Amount (Currency)
    9. Description 
    10.when to Transfer:  (Now)
    11. User able to click make another transfer to direct back to Local Transfer main screen
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer "<ToAcct>", "<ReceipientName>", "<Amount>", "<Description>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I click on Next button in Local Transfer - Details Entry Section
    And I click on Submit button in Local Transfer - Confirmation Section
    Then Verify the success message in Local Transfer - Acknowledgement Section
      | You've successfully completed the transfer |
    And I click on Make Another Transfer button in Local Transfer - Acknowledgement Section
    Then Local Transfer - Details Entry Section is displayed

    Examples: 
      | FromAcct | ReceipientBank   | ToAcct    | ReceipientName  | Amount | Description   | SMSMobileNo | whenToTransfer    | Date  |
      |    10001 | AAA Bank Limited | 000570581 | LocalReceipient |  10.10 | LocalTransfer |   123456790 | One Time Transfer | Today |

  Scenario Outline: S016_TC04_Verify Local Transfer function, Success screen and Click on Done button [One Time Transfer, from USD account]
    [
    The Local Transfer Success screen should show and allow user as below
    Green ribbon with copy "You've successfully completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient account number
    7. Recipient Name
    8. Amount (Currency)
    9. Description 
    10.when to Transfer:  (Now) 
    12. User able to click Done to direct to main dashboard
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer "<ToAcct>", "<ReceipientName>", "<Amount>", "<Description>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I click on Next button in Local Transfer - Details Entry Section
    And I click on Submit button in Local Transfer - Confirmation Section
    Then Verify the success message in Local Transfer - Acknowledgement Section
      | You've successfully completed the transfer |
    And I click on Done button in Local Transfer - Acknowledgement Section
    Then I m navigated to home page

    Examples: 
      | FromAcct | ReceipientBank   | ToAcct    | ReceipientName  | Amount | Description   | SMSMobileNo | whenToTransfer    | Date  |
      |    10001 | AAA Bank Limited | 000570581 | LocalReceipient |  10.10 | LocalTransfer |   123456790 | One Time Transfer | Today |

  Scenario Outline: S016_TC05_Verify Local Transfer Details Entry section elements are displayed [Recurring Transfer, from USD account]
    
    [
    The Local Transfer screen should show and allow user as below
    1. User to be able to select the account to transfer from via drop down
    2. User to select recipient bank via drop down
    3. User to enter the recipient account number
    4. User to enter recipient name
    5. User to enter amount to transfer (the currency will base on sender account)
    6. User to enter description of transfer
    7. Use to select either “One time transfer” or Recurring Transfer”   - Recurring Transfer – user to enter 
        - Enter Starting date 
        - Choose in drop down on repeat frequency
       - Choose number of times to repeat
    8. User to enter the phone number if user wants to Send SMS Notification (Optional) 
    9. click User to click next
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select from account "<FromAcct>" in Local Transfer - Details Entry Section
    And I select when to transfer radio button in Local Transfer - Details Entry Section
      | Recurring Transfer |
    Then Verify all elements are displayed in Local Transfer - Details Entry Section for Recurring Transfer

    Examples: 
      | FromAcct |
      |    10001 |

  Scenario Outline: S016_TC06_Verify Local Transfer Confirmation screen [Recurring Transfer, from USD account]
    [
      The Local Transfer Success screen should show and allow user as below
      Green ribbon with copy "You've successfuly completed the transfer"
      1. Reference Number
      2. Transaction Status
      3. Transaction Date,Time
      4. From account 
      5. Recipient Bank 
      6. Recipient account number
      7. Recipient Name
      8. Amount (Currency)
      9. Description 
      10.when to Transfer:  (Now)
      11. User able to click make another transfer to direct back to Local Transfer main screen
      12. User able to click Done to direct to main dashboard
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer "<ToAcct>", "<ReceipientName>", "<Amount>", "<Description>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I Select Repeat frequency "<Repeat>" and Number of times "<NumOfTimes>"
    And I click on Next button in Local Transfer - Details Entry Section
    Then Verify that all details displayed correctly in Local Transfer - Confirmation Section for Recurring Transfer

    Examples: 
      | FromAcct | ReceipientBank   | ToAcct    | ReceipientName  | Amount | Description   | SMSMobileNo | whenToTransfer     | Date        | Repeat    | NumOfTimes |
      |    10001 | AAA Bank Limited | 000570581 | LocalReceipient |  10.10 | LocalTransfer |   123456790 | Recurring Transfer | 30/Dec/2023 | Quarterly |          2 |

  Scenario Outline: S016_TC07_Verify Local Transfer function, Success screen and Click on Make Another Transfer [Recurring Transfer, from USD account]
    [
    The Local Transfer Success screen should show and allow user as below
    Green ribbon with copy "You've successfuly completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient account number
    7. Recipient Name
    8. Amount (Currency)
    9. Description 
    10.when to Transfer:  (Now)
    11. User able to click make another transfer to direct back to Local Transfer main screen
    12. User able to click Done to direct to main dashboard
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer "<ToAcct>", "<ReceipientName>", "<Amount>", "<Description>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I Select Repeat frequency "<Repeat>" and Number of times "<NumOfTimes>"
    And I click on Next button in Local Transfer - Details Entry Section
    And I click on Submit button in Local Transfer - Confirmation Section
    Then Verify the success message in Local Transfer - Acknowledgement Section
      | You've successfully completed the transfer |
    And I click on Make Another Transfer button in Local Transfer - Acknowledgement Section
    Then Local Transfer - Details Entry Section is displayed

    Examples: 
      | FromAcct | ReceipientBank   | ToAcct    | ReceipientName  | Amount | Description   | SMSMobileNo | whenToTransfer     | Date        | Repeat    | NumOfTimes |
      |    10001 | AAA Bank Limited | 000570581 | LocalReceipient |  10.10 | LocalTransfer |   123456790 | Recurring Transfer | 30/Dec/2023 | Quarterly |          2 |

  Scenario Outline: S016_TC08_Verify Local Transfer function, Success screen and Click on Done button [Recurring Transfer, from USD account]
    [
    The Local Transfer Success screen should show and allow user as below
    Green ribbon with copy "You've successfuly completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient account number
    7. Recipient Name
    8. Amount (Currency)
    9. Description 
    10.when to Transfer:  (Now)
    11. User able to click make another transfer to direct back to Local Transfer main screen
    12. User able to click Done to direct to main dashboard
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer "<ToAcct>", "<ReceipientName>", "<Amount>", "<Description>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I Select Repeat frequency "<Repeat>" and Number of times "<NumOfTimes>"
    And I click on Next button in Local Transfer - Details Entry Section
    And I click on Submit button in Local Transfer - Confirmation Section
    Then Verify the success message in Local Transfer - Acknowledgement Section
      | You've successfully completed the transfer |
    And I click on Done button in Local Transfer - Acknowledgement Section
    Then I m navigated to home page

    Examples: 
      | FromAcct | ReceipientBank   | ToAcct    | ReceipientName  | Amount | Description   | SMSMobileNo | whenToTransfer     | Date        | Repeat    | NumOfTimes |
      |    10001 | AAA Bank Limited | 000570581 | LocalReceipient |  10.10 | LocalTransfer |   123456790 | Recurring Transfer | 30/Dec/2023 | Quarterly |          2 |

  Scenario Outline: S016_TC09_Verify Local Transfer without input To Account [Select from acct as USD acct]
    [
      -> fill in all field, exclude the To Accuont and click Next button 
      The Local Transfer screen should show user as below
      - System will show message error "Please input the Account number"
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer "<ReceipientName>", "<Amount>", "<Description>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I click on Next button in Local Transfer - Details Entry Section
    Then Verify the error message for To Account in Local Transfer - Details Entry Section
      | To Account is required |

    Examples: 
      | FromAcct | ReceipientBank   | ReceipientName  | Amount | Description   | SMSMobileNo | whenToTransfer    | Date  |
      |    10001 | AAA Bank Limited | LocalReceipient |  10.10 | LocalTransfer |   123456790 | One Time Transfer | Today |

  Scenario Outline: S016_TC10_Verify Local Transfer without input the Amount [Select From account as USD account]
    [	
       -> fill in all field, exclude the Amount and click Next button 
       The Local Transfer screen should show user as below
       - System will show message error "Please input the Amount"
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer "<ToAcct>" "<ReceipientName>",  "<Description>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I click on Next button in Local Transfer - Details Entry Section
    Then Verify the error message for Amount in Local Transfer - Details Entry Section
      | Amount is required |

    Examples: 
      | FromAcct | ReceipientBank   | ToAcct    | ReceipientName  | Description   | SMSMobileNo | whenToTransfer    | Date  |
      |    10001 | AAA Bank Limited | 000570581 | LocalReceipient | LocalTransfer |   123456790 | One Time Transfer | Today |

  Scenario Outline: S016_TC11_Verify Local Transfer without input the Decription [Select From account as USD account]
    
    [	-> fill in all field, exclude the Decription and click Next button 
    	The Local Transfer screen should show user as below
    - System will show message error "Please input the Decription"
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I select "<FromAcct>" ,"<ReceipientBank>" in Local Transfer - Details Entry Section
    And I key in details for the Local Transfer without description "<ToAcct>", "<ReceipientName>", "<Amount>", "<SMSMobileNo>"
    And I Select when to Transfer "<whenToTransfer>" and select date "<Date>"
    And I click on Next button in Local Transfer - Details Entry Section
    Then Verify the error message for Amount in Local Transfer - Details Entry Section
      | Description is required |

    Examples: 
      | FromAcct | ReceipientBank   | ToAcct    | ReceipientName  | Amount | SMSMobileNo | whenToTransfer    | Date  |
      |    10001 | AAA Bank Limited | 000570581 | LocalReceipient |  11.11 |   123456790 | One Time Transfer | Today |

  Scenario: S016_TC12_Verify error messages for To Account, Receipient Name, Amount, Description when they are empty
    [
    Click on Next button without key in any value in Local Transfer - Details Entry Section
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I click on Next button in Local Transfer - Details Entry Section
    Then Verify error messages for To Account, Receipient Name, Amount, Description
      | To Account is required     |
      | Recipient Name is required |
      | Amount is required         |
      | Description is required    |

  
  Scenario Outline: S016_TC13_Verify Add Favourite function from menu provided in Local Transfer screen [Click Yes in pop up]
    [
     Adding Favourite account:
     1.  User to click on Add Favourite
     2. Pop-up will be prompted with copy "You will be directed to another page and will be exiting this transfer transaction. Would you like to proceed?"
     3. if user clicks "Yes", user will be directed to "manage favourite accounts" first
     
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I click on Add Favourite menu in Local Transfer - Details Entry Section
    And I click on Yes button in Add Favourite pop up in Local Transfer - Details Entry Section
    And Select the Transaction Type "<TranType>" in Manage My Favourite Accounts screen
    And Key in the Favourite Account details in Manage My Favoutite Accounts screen "<ReceipientBank>", "<ReceipientBranch>", "<ToAccount>", "<RecipientName>", "<FavouriteAccountName>"
    And Click on Next button in Manage Favourite Accounts screen
    And Key in the TAC in Manage Favoutite Accounts-Receipient information section
    And Click on Submit button in Manage Favourite Accounts-Receipient information section
    Then Verify message "<Message>" in Manage Favourite Accounts - Acknowledgement section
    And Verify all details are displayed correctly in Manage Favourite Accounts - Acknowledgement section Local Transfer
    And Click on Done button in Manage Favourite Accounts - Acknowledgement section
    Then I m navigated to home page

    Examples: 
      | TranType       | ReceipientBank   | ReceipientBranch | ToAccount | RecipientName  | FavouriteAccountName | Message                 |
      | Local Transfer | AAA Bank Limited | Cambodia         | 000570581 | LocalRecipient | LocalTransferOne     | Added a favourite payee |
	
	
  Scenario: S016_TC14_Verify Add Favourite menu provided in Local Transfer screen and click No
    [
     Adding Favourite account:
     1.  User to click on Add Favourite
     2. Pop-up will be prompted with copy "You will be directed to another page and will be exiting this transfer transaction. Would you like to proceed?"
     4. if user clicks "No", user will go back to transfer to main Local transfer screen
    ]

    When I m navigated to Local Transfer - Details Entry Section
    And I click on Add Favourite menu in Local Transfer - Details Entry Section
    And I click on No button in Add Favourite pop up in Local Transfer - Details Entry Section
    Then I m navigated to Local Transfer- Details Entry main screen
 	
 	
  Scenario: S016_TC15_Verify Favourites accounts, Add Favourite menu and Delete button are visible in Local Transfer screen
    [
    
     TheLocal Transfer screen should show and allow user as below
     1. Favourites accounts will be on the left where user has option to add and delete favourite
     2. If user click bin icon, user will be able to select which account to delete via radio button. Bin icon should simulate opened bin cover
     
    ]

			When I m navigated to Local Transfer - Details Entry Section
			Then Verify Add Favourite menu and Delete button icon are displayed in Local Transfer - Details Entry Section
	
	
  Scenario: S016_TC16_Verify Delete Favourite Account functionality in Local Transfer screen
    [
     Verify delete functionality
     Verify delet confirmation pop up
     Verify record is deleted after delete action	
    ]
		When I m navigated to Local Transfer - Details Entry Section
    And I click on Delete or Bin icon button in Local Transfer - Details Entry Section
    And I click on Checkbox to selet the record for deletion in Local Transfer - Details Entry Section
    And I click on Yes button in Local Transfer - Details Entry Section pop up to confirm the deletion
    Then Favourite Record deleted successfully under Local Transfer
    