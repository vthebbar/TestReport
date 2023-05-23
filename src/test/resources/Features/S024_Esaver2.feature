Feature: S024_ Esaver feature - Create Account

  Background: 
    Given I m logged in
    And I m navigated to E-Saver Create Account screen

  Scenario: S024_TC01_Verify Create Account screen
    [
    	Verify all fields are displayed in Create Account screen:
    	
    	The Create Account screen should show :
       1.  Account Name
       2.  Debiting Account via dropdown
       3. Amount
       4. Description (Optional)
       5. Next button 
       6. Checkboxes: Product Term Sheet and T&C 
       
    ]

    Then Verify all fields specified above are displayed in the screen

  Scenario Outline: S024_TC02_Verify minimum initial amount value less than 100 USD [Negative test]
    [
     when amount keyed in is less than USD100, message should display as below:
     The minimum initial deposit amount is USD100.00. (2252)
    ]

    When I select, key in the details "<AccountName>" , "<DebitAccount>" , "<Amount>" , "<Description>" in E-Saver Create Account - Enter Details section
    And I Select checkboxes for Product Term Sheet , Terms and Conditions in E-Saver Create Account - Enter Details section
    And I click on Next button in E-Saver Create Account - Enter Details section
    Then Verify the error message in E-Saver Create Account - Enter Details section
      | The minimum initial deposit amount is USD100.00. (2252) |

    Examples: 
      | AccountName | DebitAccount | Amount | Description      |
      | EsaverV     |        10001 |     99 | less than 100usd |

  Scenario Outline: S024_TC03_Verify Create Account without input the Account Name  [Negative test]
    [
      The Create Account screen should show and allow user as below
      - System will show message error "Account Name is required"
    ]

    When I select, key in the details "<DebitAccount>" , "<Amount>" , "<Description>" in E-Saver Create Account - Enter Details section
    And I Select checkboxes for Product Term Sheet , Terms and Conditions in E-Saver Create Account - Enter Details section
    And I click on Next button in E-Saver Create Account - Enter Details section
    Then Verify the error message in E-Saver Create Account - Enter Details section for Account Name field
      | Account Name is required |

    Examples: 
      | DebitAccount | Amount | Description  |
      |        10001 |     99 | no acct name |

  Scenario Outline: S024_TC04_Verify Create Account without input the Amount screen [Negative test]
    [
       The Create Account screen should show and allow user as below
      - System will show message error "Amount is required"
    ]

    When I select or key in the details "<AccountName>" , "<DebitAccount>" , "<Description>" in E-Saver Create Account - Enter Details section-
    And I Select checkboxes for Product Term Sheet , Terms and Conditions in E-Saver Create Account - Enter Details section
    And I click on Next button in E-Saver Create Account - Enter Details section
    Then Verify the error message in E-Saver Create Account - Enter Details section for amount field
      | Amount is required |

    Examples: 
      | AccountName | DebitAccount | Description |
      | EsaverV     |        10001 | No amount   |

  Scenario Outline: S024_TC05_Verify Create Account confirmation detail screen
    [
      The Create Account confirmation detail screen should show and allow user as below
      1. Account Name informaiton
      2. Debiting Account information
      3. Amount information
      4. Use to be able to key in the TAC and click submit
    ]

    When I select, key in the details "<AccountName>" , "<DebitAccount>" , "<Amount>" , "<Description>" in E-Saver Create Account - Enter Details section
    And I Select checkboxes for Product Term Sheet , Terms and Conditions in E-Saver Create Account - Enter Details section
    And I click on Next button in E-Saver Create Account - Enter Details section
    Then Verify the E-Saver Create Account - Confirm Details section

    Examples: 
      | AccountName | DebitAccount | Amount | Description    |
      | EsaverV     |        10001 |    101 | confirm screen |

  Scenario Outline: S024_TC06_Verify Create Account with invalid TAC screen  [Negative test]
    [
     The Create Account confirmation detail screen should show and allow user as below
     1. Account Name informaiton
     2. Debiting Account information
     3. Amount information
     4. Use to be able to key in the with invalid TAC and click submit
     5. System will show message error "You've entered an invalid code. Please ensure you key in the correct code. (2076)"
    		
    ]

    When I select, key in the details "<AccountName>" , "<DebitAccount>" , "<Amount>" , "<Description>" in E-Saver Create Account - Enter Details section
    And I Select checkboxes for Product Term Sheet , Terms and Conditions in E-Saver Create Account - Enter Details section
    And I click on Next button in E-Saver Create Account - Enter Details section
    And I key in invalid TAC in E-Saver Create Account - Confirm Details section
      | 112233 |
    And I click on Submit button in E-Saver Create Account - Confirm Details section
    Then Verify the error message in E-Saver Create Account - Confirm Details section
      | You've entered an invalid code. Please ensure you key in the correct code. (2076) |

    Examples: 
      | AccountName | DebitAccount | Amount | Description |
      | EsaverV     |        10001 |    101 | invalid TAC |
	
	
  Scenario Outline: S024_TC07_Verify Create Account Acknowledgement screen
    [
      The Create Account Acknowledgement screen should show user as below
      1. Reference Number information
      2. Transaction Date, Time informaiton
      3. E-Saver Account Number information
      4. Account Name information  
      5. Debiting Account information 
      6. Amount information 
      7. Transaction Status information  
      8. Balance After Transfer informaiton
      9. Messasge show "You've successfully created your E-Saver account." and Done button
      
    ]

    When I select, key in the details "<AccountName>" , "<DebitAccount>" , "<Amount>" , "<Description>" in E-Saver Create Account - Enter Details section
    And I Select checkboxes for Product Term Sheet , Terms and Conditions in E-Saver Create Account - Enter Details section
    And I click on Next button in E-Saver Create Account - Enter Details section
    And I key in valid TAC in E-Saver Create Account - Confirm Details section
    And I click on Submit button in E-Saver Create Account - Confirm Details section
    Then Verify the success message in E-Saver Create Account - Acknowledgement section
      | You've successfully created your E-Saver account. |
    And Verify the other details in E-Saver Create Account - Acknowledgement section
    And I click on Done button in E-Saver Create Account - Acknowledgement section
    Then I m navigated to home page

    Examples: 
      | AccountName | DebitAccount | Amount | Description     |
      | EsaverV     |        10001 |    101 | successScenario |
