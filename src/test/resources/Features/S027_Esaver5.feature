Feature: S027_ Esaver feature - Close Account

  Background: 
    Given I m logged in
    And I m navigated to E-Saver Close Account screen

  Scenario Outline: S027_TC01_Verify Close Account (Own Account Transfer) screen
    
    [
    The Close Account (Own Account Transfer) screen should show  as below
    	1. Users to be able to select the Account via dropdown
    	2. Product 
    	3. Status 
    	4. Sattlement Balance 
    	5. Closing Fee 
    	6. Total Amount 
    	7. Users to be able to select the Reason For Closing via dropdown
    	8. Users to be able to select the Select Transfer Type via dropdow (Own Account Transfer / 3rd Party HLB Account Transfer) then click next
    	9. Users to be able to select the Own Account via drop down then click next
    ]

    And I select the Transfer Type "<TransferType>" in E-Saver Close Account - Enter Details Section
    Then Verify above specified fields are displayed in  E-Saver Close Account - Enter Details Section

    Examples: 
      | TransferType         |
      | Own Account Transfer |

  Scenario Outline: S027_TC02_Verify Close Account (Own Account Transfer) without select the Reason For Closing screen [Negative test]
    
    [
      The Close Account (Own Account Transfer) screen should show and allow user as below
      - System will show message error "Reason For Closing is required"
    ]

    When I select the Account Number "<AcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I select the Transfer Type "<TransferType>" in E-Saver Close Account - Enter Details Section
    And I select the Own Account Number "<OwnAcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I click on Next button in E-Saver Close Account - Enter Details Section
    Then Verify the error message displayed in E-Saver Close Account - Enter Details Section
      | Reason For Closing is required |

    Examples: 
      | AcctNumIndexVal | TransferType         | OwnAcctNumIndexVal |
      |               1 | Own Account Transfer |                  1 |

  Scenario Outline: S027_TC03_Verify Close Account (Own Account Transfer) without Select the Transfer Type screen [Negative test]
    [
    The Close Account (Own Account Transfer) screen should show and allow user as below
    - System will show message error "Select Transfer Type is required"
    ]

    When I select the Account Number "<AcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I select the Reason for Closing "<ReasonForClosing>" in E-Saver Close Account - Enter Details Section
    And I click on Next button in E-Saver Close Account - Enter Details Section
    Then Verify the error message displayed in E-Saver Close Account - Enter Details Section
      | Select Transfer Type is required |

    Examples: 
      | AcctNumIndexVal | ReasonForClosing |
      |               1 | Product Features |

  Scenario Outline: S027_TC04_Verify Close Account (Own Account Transfer) Confirmation detail screen
    [
    		The Close Account (Own Account Transfer) Confirmation detail screen should show user as below
    	1. Account information 
    	2. Product Information 
    	3. Settlement Balance information 
    	4. Closing Fee information 
    	5. Total Amount information 
    	6. Reason For Closing information 
    	7. Transfer Type information (Own Account Transfer) 
    	8. to account
    	9. user able to click next
    
    ]

    When I select the Account Number "<AcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I select the Reason for Closing "<ReasonForClosing>" in E-Saver Close Account - Enter Details Section
    And I select the Transfer Type "<TransferType>" in E-Saver Close Account - Enter Details Section
    And I select the Own Account Number "<OwnAcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I click on Next button in E-Saver Close Account - Enter Details Section
    Then Verify E-Saver Close Account - Confirm Details Section

    Examples: 
      | AcctNumIndexVal | ReasonForClosing | TransferType         | OwnAcctNumIndexVal |
      |               1 | Interest Rate    | Own Account Transfer |                  1 |

  Scenario Outline: S027_TC05_Verify Close Account (Own Account Transfer) Acknowledgement screen
    [
    The Close Account (Own Account Transfer) Acknowledgement screen should show user as below
    1. Reference Number informaiton 
    2. Account information 
    3. Product Information 
    4. Settlement Balance information 
    5. Closing Fee information 
    6. Total Amount information 
    7. Reason For Closing information 
    8. Transfer Type information (Own Account Transfer) 
    9. To Account information and Done button
    10. Message show "You've successfully closed your E-Saver account."
    
    ]

    When I select the Account Number "<AcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I select the Reason for Closing "<ReasonForClosing>" in E-Saver Close Account - Enter Details Section
    And I select the Transfer Type "<TransferType>" in E-Saver Close Account - Enter Details Section
    And I select the Own Account Number "<OwnAcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I click on Next button in E-Saver Close Account - Enter Details Section
    And I click on Submit button in E-Saver Close Account - Confirm Details Section
    Then Verify the success mesage in E-Saver Close Account - Acknowledgement Section
      | You've successfully closed your E-Saver account. |
    And Verify the other details in E-Saver Close Account - Acknowledgement Section
    And I click on Done button in E-Saver Close Account - Acknowledgement Section
    Then I m navigated to home page

    Examples: 
      | AcctNumIndexVal | ReasonForClosing | TransferType         | OwnAcctNumIndexVal |
      |               1 | Interest Rate    | Own Account Transfer |                  1 |

  Scenario Outline: S027_TC06_Verify Close Account (3rd Party HLB Account Transfer) screen
    [
    The Close Account screen should show as below
    1. Users to be able to select the Account via dropdown
    2. Producet auto pop up
    3. Status auto pop up
    4. Sattlement Balance auto pop up 
    5. Closing Fee auto pop up 
    6. Total Amount auto pop up
    7. Users to be able to select the Reason For Closing via dropdow
    8. Users to be able to select the Select Transfer Type via dropdow (3rd Party HLB Account Transfer)
    9. User to be able to select the 3rd Party HLB Account Transfer 
    10. User to be able to select the favorite account or non-favorite account
    11. if user select favorite, user able to select account to transfer via drop down
    12. If user select non favorite, user able to key recipient account number
    12. user able to key in recipient reference
    13. Use to be able to key in the Description (Optional) then click next
    ]

    When I select the Account Number "<AcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I select the Reason for Closing "<ReasonForClosing>" in E-Saver Close Account - Enter Details Section
    And I select the Transfer Type "<TransferType>" in E-Saver Close Account - Enter Details Section
    Then Verify above specified fields are displayed in  E-Saver Close Account - Enter Details Section third party transfer

    Examples: 
      | AcctNumIndexVal | ReasonForClosing | TransferType                   |
      |               0 | Interest Rate    | 3rd Party HLB Account Transfer |
	
	@TEST
  Scenario Outline: S027_TC07_Verify Close Account (3rd Party HLB Account Transfer) without input the Recipient Reference
    [
      The Close Account screen should show and allow user as below
      - System will show message error "Recipient Reference is required"		
    ]

    When I select the Account Number "<AcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    And I select the Reason for Closing "<ReasonForClosing>" in E-Saver Close Account - Enter Details Section
    And I select the Transfer Type "<TransferType>" in E-Saver Close Account - Enter Details Section
    And I select the Account category "<AcctCategory>" in E-Saver Close Account - Enter Details Section
    And I key in To Account "<ToAcct>" in E-Saver Close Account - Enter Details Section
    And I clear the value in Recipient Reference field in E-Saver Close Account - Enter Details Section
    And I click on Next button in E-Saver Close Account - Enter Details Section
    Then Verify the error message displayed in E-Saver Close Account - Enter Details Section
      | Recipient Reference is required |

    Examples: 
      | AcctNumIndexVal | ReasonForClosing | TransferType                   | AcctCategory | ToAcct           |
      |               0 | Interest Rate    | 3rd Party HLB Account Transfer | Non-Favorite | 1010001000058932 |

  #Scenario Outline: S027_TC08_Verify Close Account (3rd Party HLB Account Transferr) Confirmation detail screen [Non-Favourite]
    #[
    #			The Close Account (3rd Party HLB Account Transfer) Confirmation detail screen should show and allow user as below
    #	1. Account information 
    #	2. Product Information 
    #	3. Settlement Balance information 
    #	4. Closing Fee information 
    #	5. Total Amount information 
    #	6. Reason For Closing information 
    #	7. Transfer Type information (3rd Party HLB Account Transfer)
    #	8. To Account information 
    #	9. Recipient Reference information 
    #	10. User to be key in the Enter TAC and then click submit
    #]
#
    #When I select the Account Number "<AcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    #And I select the Reason for Closing "<ReasonForClosing>" in E-Saver Close Account - Enter Details Section
    #And I select the Transfer Type "<TransferType>" in E-Saver Close Account - Enter Details Section
    #And I select the Account category "<AcctCategory>" in E-Saver Close Account - Enter Details Section
    #And I key in To Account "<ToAcct>" in E-Saver Close Account - Enter Details Section
    #And I key in the value "<RecipientRef>" in Recipient Reference field in E-Saver Close Account - Enter Details Section
    #And I key in the value "<Desc>" in Description field in E-Saver Close Account - Enter Details Section
    #And I click on Next button in E-Saver Close Account - Enter Details Section
    #Then Verify the  E-Saver Close Account - Confirm Details Section for third party account transfer
#
    #Examples: 
      #| AcctNumIndexVal | ReasonForClosing | TransferType                   | AcctCategory | ToAcct           | RecipientRef    | Desc            |
      #|               0 | Interest Rate    | 3rd Party HLB Account Transfer | Non-Favorite | 1010001000058932 | EsaverClose3rdp | testCloseEsaver |
#
  #Scenario Outline: S027_TC09_Verify Close Account (3rd Party HLB Account Transfer) Acknowledgement screen [Non-Favourite]
    #[
    #The Close Account (3rd Party HLB Account Transfer) Acknowledgement screen should show user as below
    #1. Reference Number informaiton 
    #2. Account information 
    #3. Product Information 
    #4. Settlement Balance information 
    #5. Closing Fee information 
    #6. Total Amount information 
    #7. Reason For Closing information 
    #8. Transfer Type information (3rd Party HLB Account Transfer)
    #9. To Account information 
    #10. Recipient Reference information and Done button
    #11. Message show "You've successfully closed your E-Saver account"
    #
    #]
#
    #When I select the Account Number "<AcctNumIndexVal>" in E-Saver Close Account - Enter Details Section
    #And I select the Reason for Closing "<ReasonForClosing>" in E-Saver Close Account - Enter Details Section
    #And I select the Transfer Type "<TransferType>" in E-Saver Close Account - Enter Details Section
    #And I select the Account category "<AcctCategory>" in E-Saver Close Account - Enter Details Section
    #And I key in To Account "<ToAcct>" in E-Saver Close Account - Enter Details Section
    #And I key in the value "<RecipientRef>" in Recipient Reference field in E-Saver Close Account - Enter Details Section
    #And I key in the value "<Desc>" in Description field in E-Saver Close Account - Enter Details Section
    #And I click on Next button in E-Saver Close Account - Enter Details Section
    #And I key in TAC in  E-Saver Close Account - Confirm Details Section
    #And I click on Submit button in E-Saver Close Account - Confirm Details Section
    #Then Verify the success mesage in E-Saver Close Account - Acknowledgement Section
      #| You've successfully closed your E-Saver account. |
    #And Verify the other details in E-Saver Close Account - Acknowledgement Section - third party
    #And I click on Done button in E-Saver Close Account - Acknowledgement Section
    #Then I m navigated to home page
#
    #Examples: 
      #| AcctNumIndexVal | ReasonForClosing | TransferType                   | AcctCategory | ToAcct           | RecipientRef    | Desc            |
      #|               0 | Interest Rate    | 3rd Party HLB Account Transfer | Non-Favorite | 1010001000058932 | EsaverClose3rdp | testCloseEsaver |
