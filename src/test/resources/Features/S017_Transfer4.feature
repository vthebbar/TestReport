Feature: S017_Transfer - Overseas Transfer

  Background: 
    Given I m logged in

  Scenario: S017_TC01_Verify Overseas Transfer Details Entry section elements are displayed [One Time Transfer]
    
    [
    The Overseas Transfer screen should show and allow user as below
    1. User to be able to select the account to transfer from via drop down
    2. User to enter bank name
    3. Enter recipient bank address
    4. Enter SWIFT Code 
    5. User to enter the recipient account number
    6. User to enter recipient name
    7. User to enter amount to transfer 
    8. User to select currency to transfer
    9. User to enter description of transfer
    10. Use to select either “One time transfer” or Recurring Transfer”
       - One Time Transfer – user to enter date of transfer
    11. click User to click next
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    Then Verify all elements are displayed in Overseas Transfer - Details Entry Section

  Scenario Outline: S017_TC02_Verify Overseas Transfer Confirmation screen [One Time Transfer]
    
    [
    The Overseas Transfer Confirmation screen should show and allow user as below
    1. From account 
    2. Recipient Bank 
    3. Recipient bank address
    4. SWIFT Code
    5. To Account
    6. Recipient Name
    7. Amount  (Currency)
    8. Equivalent Amount
    9. Description 
    10. when to Transfer: 
      - One Time Transfer (Now)
    11. User to key in TAC 
    12. User to click Submit and directed to success screen
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And Select and key in details in Overseas Transfer Details Entry Section "<From>", "<RecipientBank>", "<RecipientBankAddress>","<SWIFTCode>","<ToAccount>","<RecipientName>","<Amount>","<Description>","<whenToTransfer>","<Date>"
    And Click on Next button in Overseas Transfer - Details Entry Section
    Then Verify fields are displayed in Overseas Transfer - Confirmation Section

    Examples: 
      | From  | RecipientBank | RecipientBankAddress | SWIFTCode | ToAccount | RecipientName | Amount | Description | whenToTransfer    | Date  |
      | 10001 | UBI           | kumta                | SWIFT11   |  55664422 | vish          | 108.11 | overseasTrf | One Time Transfer | Today |

  Scenario Outline: S017_TC03_Verify Overseas Transfer Acknowledgement/Success screen and click on Make Another Transfer [One Time Transfer]
    
    [
    The Overseas Transfer Success screen should show and allow user as below
    Green ribbon with copy "You've successfully completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient bank address
    7. SWIFT Code
    8. To Account
    9. Recipient Name
    10. Amount  (Currency)
    11. Equivalent Amount
    12. Description 
    13. when to Transfer:  (Now)
    14. User able to click make another transfer to direct back to Overseas Transfer main screen
    
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And Select and key in details in Overseas Transfer Details Entry Section "<From>", "<RecipientBank>", "<RecipientBankAddress>","<SWIFTCode>","<ToAccount>","<RecipientName>","<Amount>","<Description>","<whenToTransfer>","<Date>"
    And Click on Next button in Overseas Transfer - Details Entry Section
    And Key in TAC code in Overseas Transfer - Confirmation Section
    And Click on Submit button in Overseas Transfer - Confirmation Section
    Then Verify the success message in Overseas Transfer - Acknowledgement Section
      | Your transfer request has been successful and will now be processed |
    And Verify fields are displayed in Overseas Transfer - Acknowledgement Section
    And Click on Make Another Transfer button in Overseas Transfer - Acknowledgement Section
    Then I m navigated to Overseas Transfer - initial data entry screen

    Examples: 
      | From  | RecipientBank | RecipientBankAddress | SWIFTCode | ToAccount | RecipientName | Amount | Description | whenToTransfer    | Date  |
      | 10001 | UBI           | kumta                | SWIFT11   |  55664422 | vish          | 108.11 | overseasTrf | One Time Transfer | Today |

  Scenario Outline: S017_TC04_Verify Overseas Transfer Acknowledgement/Success screen and click on Dpne button [One Time Transfer]
    
    [
    The Overseas Transfer Success screen should show and allow user as below
    Green ribbon with copy "You've successfully completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient bank address
    7. SWIFT Code
    8. To Account
    9. Recipient Name
    10. Amount  (Currency)
    11. Equivalent Amount
    12. Description 
    13. when to Transfer:  (Now)
    15. User able to click Done to direct to main dashboard
    
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And Select and key in details in Overseas Transfer Details Entry Section "<From>", "<RecipientBank>", "<RecipientBankAddress>","<SWIFTCode>","<ToAccount>","<RecipientName>","<Amount>","<Description>","<whenToTransfer>","<Date>"
    And Click on Next button in Overseas Transfer - Details Entry Section
    And Key in TAC code in Overseas Transfer - Confirmation Section
    And Click on Submit button in Overseas Transfer - Confirmation Section
    Then Verify the success message in Overseas Transfer - Acknowledgement Section
      | Your transfer request has been successful and will now be processed |
    And Verify fields are displayed in Overseas Transfer - Acknowledgement Section
    And Click on Done button in Overseas Transfer - Acknowledgement Section
    Then I m navigated to home page

    Examples: 
      | From  | RecipientBank | RecipientBankAddress | SWIFTCode | ToAccount | RecipientName | Amount | Description | whenToTransfer    | Date  |
      | 10001 | UBI           | kumta                | SWIFT11   |  55664422 | vish          | 108.11 | overseasTrf | One Time Transfer | Today |

  Scenario: S017_TC05_Verify Overseas Transfer Details Entry section elements are displayed [Recurring Transfer]
    
    [
    	The Overseas Transfer screen should show and allow user as below
    	1. User to be able to select the account to transfer from via drop down
    	2. User to enter bank name
    	3. Enter recipient bank address
    	4. Enter SWIFT Code 
    	5. User to enter the recipient account number
    	6. User to enter recipient name
    	7. User to enter amount to transfer 
    	8. User to select currency to transfer
    	9. User to enter description of transfer
    	10. Use to select either “One time transfer” or Recurring Transfer”   - Recurring Transfer – user to enter 
    	     - Enter Starting date 
    	     - Choose in drop down on repeat frequency
    	    - Choose number of times to repeat
    	11. User to enter the phone number if user wants to Send SMS Notification (Optional) 
    	12. click User to click next
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And I when to transfer radio button in Overseas Transfer - Details Entry
      | Recurring Transfer |
    Then Verify all elements are displayed in Overseas Transfer - Details Entry Section Recurring Transfer

  Scenario Outline: S017_TC06_Verify Overseas Transfer Confirmation screen [Recurring Transfer]
    
    [
     The Overseas Transfer Confirmation screen should show and allow user as below
      1. From account 
      2. Recipient Bank 
      3. Recipient bank address
      4. SWIFT Code
      5. To Account
      6. Recipient Name
      7. Amount  (Currency)
      8. Equivalent Amount
      9. Description 
      10. when to Transfer: {Transfer Type}{Start from Date}{Repeat cycle and frequency}{The last transfer Date}
      11. User to key in TAC 
      12. User to click Submit and directed to success screen
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And Select and key in details in Overseas Transfer Details Entry Section "<From>", "<RecipientBank>", "<RecipientBankAddress>","<SWIFTCode>","<ToAccount>","<RecipientName>","<Amount>","<Description>","<whenToTransfer>","<Date>"
    And Select frequency "<Frequency>" and key in number of times "<NumberOfTimes>" in Overseas Transfer - Details Entry Section
    And Click on Next button in Overseas Transfer - Details Entry Section
    Then Verify fields are displayed in Overseas Transfer - Confirmation Section - Recurring Transfer

    Examples: 
      | From  | RecipientBank | RecipientBankAddress | SWIFTCode | ToAccount | RecipientName | Amount | Description | whenToTransfer     | Date        | Frequency | NumberOfTimes |
      | 10001 | UBI           | kumta                | SWIFT11   |  55664422 | vish          | 108.11 | overseasTrf | Recurring Transfer | 15/Dec/2023 | Monthly   |             4 |

  Scenario Outline: S017_TC07_Verify Overseas Transfer Acknowledgement/Success screen and click on Make Another Transfer [Recurring Transfer]
    
    [
    The Overseas Transfer Success screen should show and allow user as below
    Green ribbon with copy "You've successfuly completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient bank address
    7. SWIFT Code
    8. To Account
    9. Recipient Name
    10. Amount  (Currency)
    11. Equivalent Amount
    12. Description 
    13.  when to Transfer:  {Transfer Type}{Start from Date}{Repeat cycle and frequency}{The last transfer Date}
    14. User able to click make another transfer to direct back to HLBCAM Transfer main screen
    
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And Select and key in details in Overseas Transfer Details Entry Section "<From>", "<RecipientBank>", "<RecipientBankAddress>","<SWIFTCode>","<ToAccount>","<RecipientName>","<Amount>","<Description>","<whenToTransfer>","<Date>"
    And Select frequency "<Frequency>" and key in number of times "<NumberOfTimes>" in Overseas Transfer - Details Entry Section
    And Click on Next button in Overseas Transfer - Details Entry Section
    And Key in TAC code in Overseas Transfer - Confirmation Section
    And Click on Submit button in Overseas Transfer - Confirmation Section
    Then Verify the success message in Overseas Transfer - Acknowledgement Section
      | Your transfer request has been successful and will now be processed |
    And Verify fields are displayed in Overseas Transfer - Acknowledgement Section - Recurring Transfer
    And Click on Make Another Transfer button in Overseas Transfer - Acknowledgement Section
    Then I m navigated to Overseas Transfer - initial data entry screen

    Examples: 
      | From  | RecipientBank | RecipientBankAddress | SWIFTCode | ToAccount | RecipientName | Amount | Description | whenToTransfer     | Date        | Frequency | NumberOfTimes |
      | 10001 | UBI           | kumta                | SWIFT11   |  55664422 | vish          | 108.11 | overseasTrf | Recurring Transfer | 15/Dec/2023 | Monthly   |             4 |

  Scenario Outline: S017_TC08_Verify Overseas Transfer Acknowledgement/Success screen and click on Done button [Recurring Transfer]
    
    [
    The Overseas Transfer Success screen should show and allow user as below
    Green ribbon with copy "You've successfuly completed the transfer"
    1. Reference Number
    2. Transaction Status
    3. Transaction Date,Time
    4. From account 
    5. Recipient Bank 
    6. Recipient bank address
    7. SWIFT Code
    8. To Account
    9. Recipient Name
    10. Amount  (Currency)
    11. Equivalent Amount
    12. Description 
    13.  when to Transfer:  {Transfer Type}{Start from Date}{Repeat cycle and frequency}{The last transfer Date}
    15. User able to click Done to direct to main dashboard
    
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And Select and key in details in Overseas Transfer Details Entry Section "<From>", "<RecipientBank>", "<RecipientBankAddress>","<SWIFTCode>","<ToAccount>","<RecipientName>","<Amount>","<Description>","<whenToTransfer>","<Date>"
    And Select frequency "<Frequency>" and key in number of times "<NumberOfTimes>" in Overseas Transfer - Details Entry Section
    And Click on Next button in Overseas Transfer - Details Entry Section
    And Key in TAC code in Overseas Transfer - Confirmation Section
    And Click on Submit button in Overseas Transfer - Confirmation Section
    Then Verify the success message in Overseas Transfer - Acknowledgement Section
      | Your transfer request has been successful and will now be processed |
    And Verify fields are displayed in Overseas Transfer - Acknowledgement Section - Recurring Transfer
    And Click on Done button in Overseas Transfer - Acknowledgement Section
    Then I m navigated to home page

    Examples: 
      | From  | RecipientBank | RecipientBankAddress | SWIFTCode | ToAccount | RecipientName | Amount | Description | whenToTransfer     | Date        | Frequency | NumberOfTimes |
      | 10001 | UBI           | kumta                | SWIFT11   |  55664422 | vish          | 108.11 | overseasTrf | Recurring Transfer | 15/Dec/2023 | Monthly   |             4 |

  Scenario: S017_TC09_Verify Overseas Transfer without input value to fields - To Account, Amount, Description
    [
      Verify error messages for below fields when they are blank:
      
      To Account  -> To Account is required
      Amount   -> Amount is required
      Description -> Description is required
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And Click on Next button in Overseas Transfer - Details Entry Section
    Then Verify error messages displayed for fields - To Account, Amount, Description
      | To Account is required  |
      | Amount is required      |
      | Description is required |

  Scenario Outline: S017_TC10_Verify Overseas Transfer with invalid TAC
    [
     Key in Invalid TAC and verify error message
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And Select and key in details in Overseas Transfer Details Entry Section "<From>", "<RecipientBank>", "<RecipientBankAddress>","<SWIFTCode>","<ToAccount>","<RecipientName>","<Amount>","<Description>","<whenToTransfer>","<Date>"
    And Select frequency "<Frequency>" and key in number of times "<NumberOfTimes>" in Overseas Transfer - Details Entry Section
    And Click on Next button in Overseas Transfer - Details Entry Section
    And Key in invalid TAC code in Overseas Transfer - Confirmation Section
      | 123456 |
    And Click on Submit button in Overseas Transfer - Confirmation Section
    Then Verify the error message for TAC in Overseas Transfer - Confirmation Section
      | You've entered an invalid code. Please ensure you key in the correct code. (2076) |

    Examples: 
      | From  | RecipientBank | RecipientBankAddress | SWIFTCode | ToAccount | RecipientName | Amount | Description | whenToTransfer     | Date        | Frequency | NumberOfTimes |
      | 10001 | UBI           | kumta                | SWIFT11   |  55664422 | vish          | 108.11 | overseasTrf | Recurring Transfer | 15/Dec/2023 | Monthly   |             4 |

 
  Scenario: S017_TC11_Click on Add Favourites menu, then click on No in pop up [ under Overseas Transfer  screen]
    [
    
    Adding Favourite account:
    	1.  User to click on Add Favourite
    	2. Pop-up will be prompted with copy "You will be directed to another page and will be exiting this transfer transaction. Would you like to proceed?"
    	4. if user clicks "No", user will go back to transfer to main Overseas transfer screen
    
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And I click on Add Favourite menu in Overseas Transfer - Details Entry Section
    And I click on No button in Add Favourite pop up in Overseas Transfer - Details Entry Section
    Then I m navigated to Overseas Transfer - Details Entry  main screen

 
  Scenario Outline: S017_TC12_Verify Add Favourites functionality under Overseas Transfer [ under Overseas Transfer screen ]
    [
    
    Adding Favourite account:
    1.  User to click on Add Favourite
    2. Pop-up will be prompted with copy "You will be directed to another page and will be exiting this transfer transaction. Would you like to proceed?"
    3. if user clicks "Yes", user will be directed to "manage favourite accounts" first
    
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And I click on Add Favourite menu in Overseas Transfer - Details Entry Section
    And I click on Yes button in Add Favourite pop up in Overseas Transfer - Details Entry Section
    And Select the Transaction Type "<TranType>" in Manage My Favourite Accounts screen
    And Select or key in the Favourite Account details in Manage My Favoutite Accounts screen "<ReceipientBank>", "<ReceipientBankAddr>", "<SwiftCode>", "<ToAccount>", "<RecipientAccountCurrency>", "<RecipientName>", "<FavAcctName>"
    And Click on Next button in Manage Favourite Accounts screen
    And Key in the TAC in Manage Favoutite Accounts-Receipient information section
    And Click on Submit button in Manage Favourite Accounts-Receipient information section
    Then Verify message "<Message>" in Manage Favourite Accounts - Acknowledgement section
    And Verify all details are displayed correctly in Manage Favourite Accounts - Acknowledgement section Overseas Transfer
    And Click on Done button in Manage Favourite Accounts - Acknowledgement section
    Then I m navigated to home page

    Examples: 
      | TranType          | ReceipientBank        | ReceipientBankAddr | SwiftCode | ToAccount  | RecipientAccountCurrency | RecipientName | FavAcctName | Message                 |
      | Overseas Transfer | Overseas Bank Limited | Cambodia           | Swift1234 | 1234567890 | USD                      | OSRecipient   | OSFavRec    | Added a favourite payee |

  
  Scenario: S017_TC13_Verify Overseas Transfer screen shows Favourite Acctuonts and delete or Bin icon [ under Overseas Transfer screen ]
    [
    Verify:
    -Favourite Account
    -Delete or bin icon are displayed
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    Then Verify Favourite account and delete or bin icon are displayed in Overseas Transfer - Details Entry Section

 
  Scenario: S017_TC14_Verify the Favourite Account delete - Click on Delete Icon and then Click on No button in pop up [under Overseas Transfer screen]
      [
        	Click on Delete Icon
        	Select Checkbox
        	Click No in delete confirmation pop up
        	
        	expected: Record should not be deleted
      ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And I click on Delete or Bin icon button in Overseas Transfer - Details Entry Section
    And I click on Checkbox to selet the record for deletion in Overseas Transfer - Details Entry Section
    And I click on No button in Overseas Transfer - Details Entry Section pop up to confirm the deletion
    Then Verify Favourite Record is NOT deleted under Overseas Transfer screen

  
  Scenario: S017_TC15_Verify the Favourite Account delete function [under Overseas Transfer screen]
    [
      Verify delete functionality
      Verify delet confirmation pop up
      Verify record is deleted after delete action	
    ]

    When I m navigated to Overseas Transfer - Details Entry Section
    And I click on Delete or Bin icon button in Overseas Transfer - Details Entry Section
    And I click on Checkbox to selet the record for deletion in Overseas Transfer - Details Entry Section
    And I click on Yes button in Overseas Transfer - Details Entry Section pop up to confirm the deletion
    Then Verify Favourite Record deleted successfully under Overseas Transfer screen
