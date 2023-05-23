Feature: S021_Fixed Deposit New Placement

  Background: 
    Given I m logged in
    And I m navigated to Fixed Deposit New Placement screen - Enter Details section

  Scenario: S021_TC01_Verify New Placement - Enter Details section
    [
    	 Verify all fields are displayed in Fixed Deposit New Placement - Enter Details Section
    ]

    Then Verify all fields are displayed in New Placement - Enter Details section

  Scenario: S021_TC02_Verify click 'here' link is working
    [
    Verify that once click on 'here' new window is opened
    ]

    When I click on here link in Fixed Deposit New Placement - Enter Details Section
    Then New window is opened with title and url as given below
      | Personal Banking                                                            |
      | https://www.hlb.com.kh/en/personal-banking/home.html/fixed-deposits-account |

  Scenario Outline: S021_TC03_Verify New Placement without selecting the Tenure [Negative test]
    [
      The Fixed Deposit Placement screen should show and allow user as below
      - System will show message error "Tenure is required"
    
    ]

    When I select From account "<FromAcctValue>" in Fixed Deposit New Placement - Enter Details Section
    And I key in principal amount "<Amount>" in Fixed Deposit New Placement - Enter Details Section
    And I Key in Remark "<Remark>" in Fixed Deposit New Placement - Enter Details Section
    And I select Renewal Instruction "<RenewalInstruction>" in Fixed Deposit New Placement - Enter Details Section
    And I click on Next button in Fixed Deposit New Placement - Enter Details Section
    Then Verify error message is displayed in Fixed Deposit New Placement - Enter Details Section
      | Tenure is required |

    Examples: 
      | FromAcctValue | Amount | Remark   | RenewalInstruction |
      |         10001 |   1001 | NoTenure | Principal only     |

  Scenario Outline: S021_TC04_Verify New Placement without input the Principal Amount [Negative test]
    [
      The Fixed Deposit Placement screen should show and allow user as below
      - System will show message error "Amount is required"
    
    ]

    When I select From account "<FromAcctValue>" in Fixed Deposit New Placement - Enter Details Section
    And I select Tenure "<Tenure>" in Fixed Deposit New Placement - Enter Details Section
    And I Key in Remark "<Remark>" in Fixed Deposit New Placement - Enter Details Section
    And I select Renewal Instruction "<RenewalInstruction>" in Fixed Deposit New Placement - Enter Details Section
    And I click on Next button in Fixed Deposit New Placement - Enter Details Section
    Then Verify error message is displayed in Fixed Deposit New Placement - Enter Details Section
      | Amount is required |

    Examples: 
      | FromAcctValue | Tenure    | Remark    | RenewalInstruction |
      |         10001 | 12 months | No Amount | Principal only     |

  Scenario Outline: S021_TC05_Verify New Placement without selecting the Renewal Instruction [Negative test]
    [
    The Fixed Deposit Placement screen should show and allow user as below
    - System will show message error "Renewal Instruction is required"
    
    ]

    When I select From account "<FromAcctValue>" in Fixed Deposit New Placement - Enter Details Section
    And I key in principal amount "<Amount>" in Fixed Deposit New Placement - Enter Details Section
    And I select Tenure "<Tenure>" in Fixed Deposit New Placement - Enter Details Section
    And I Key in Remark "<Remark>" in Fixed Deposit New Placement - Enter Details Section
    And I click on Next button in Fixed Deposit New Placement - Enter Details Section
    Then Verify error message is displayed in Fixed Deposit New Placement - Enter Details Section
      | Renewal Instruction is required |

    Examples: 
      | FromAcctValue | Amount | Tenure    | Remark         |
      |         10001 |   1001 | 12 months | NoRenewalInstr |

  Scenario Outline: S021_TC06_Verify New Placement if principal amount is less than USD 1,000 [Negative test]
    [
    The Fixed Deposit Placement screen should show and allow user as below
    - System will show message error "Please ensure the amount is more than or equal to the minimum Fixed Deposit placement limit. (2128)"
    
    ]

    When I select From account "<FromAcctValue>" in Fixed Deposit New Placement - Enter Details Section
    And I select Tenure "<Tenure>" in Fixed Deposit New Placement - Enter Details Section
    And I key in principal amount "<Amount>" in Fixed Deposit New Placement - Enter Details Section
    And I Key in Remark "<Remark>" in Fixed Deposit New Placement - Enter Details Section
    And I select Renewal Instruction "<RenewalInstruction>" in Fixed Deposit New Placement - Enter Details Section
    And I click on Next button in Fixed Deposit New Placement - Enter Details Section
    Then Verify error message is displayed in Fixed Deposit New Placement - Enter Details Section - amount field
      | Please ensure the amount is more than or equal to the minimum Fixed Deposit placement limit. (2128) |

    Examples: 
      | FromAcctValue | Tenure    | Amount | Remark        | RenewalInstruction |
      |         10001 | 12 months |    999 | lessthan1kusd | Principal only     |

  Scenario Outline: S021_TC07_Verify New Placement If insufficient funds [Negative test]
    [
    The Fixed Deposit Placement screen should show and allow user as below
    - System will show message error "Please ensure there is sufficient fund in From account to proceed with the payment. (2134)"
    
    ]

    And I select Tenure "<Tenure>" in Fixed Deposit New Placement - Enter Details Section
    And I key in principal amount "<Amount>" in Fixed Deposit New Placement - Enter Details Section
    And I Key in Remark "<Remark>" in Fixed Deposit New Placement - Enter Details Section
    And I select Renewal Instruction "<RenewalInstruction>" in Fixed Deposit New Placement - Enter Details Section
    And I click on Next button in Fixed Deposit New Placement - Enter Details Section
    Then Verify error message is displayed in Fixed Deposit New Placement - Enter Details Section - amount field
      | Please ensure there is sufficient fund in From account to proceed with the payment. (2134) |

    Examples: 
      | Tenure    | Amount       | Remark           | RenewalInstruction     |
      | 12 months | 592000000000 | insufficientfund | Principal and Interest |

  Scenario Outline: S021_TC08_Verify New Placement confirmation detail screen
    [
    
    		The Fixed Deposit Placement confirmation detail screen should show and allow user as below
    		1. From account
    		2. Tenure
    		3. Principal Amount 
    		4. Remarks  (Optional)
    		5. Maturity Instruction information 
    		6. Renewal Instruction information
    		7. Rate (%) information 
    		8. Effective Date information
    		9. Use to be able to key in TAC and click next button
    
    ]

    When I select From account "<FromAcctValue>" in Fixed Deposit New Placement - Enter Details Section
    And I select Tenure "<Tenure>" in Fixed Deposit New Placement - Enter Details Section
    And I key in principal amount "<Amount>" in Fixed Deposit New Placement - Enter Details Section
    And I Key in Remark "<Remark>" in Fixed Deposit New Placement - Enter Details Section
    And I select Renewal Instruction "<RenewalInstruction>" in Fixed Deposit New Placement - Enter Details Section
    And I click on Next button in Fixed Deposit New Placement - Enter Details Section
    Then Verify Fixed Deposit New Placement - Confirm Details Section

    Examples: 
      | FromAcctValue | Tenure    | Amount | Remark           | RenewalInstruction     |
      |         10001 | 12 months |   1001 | insufficientfund | Principal and Interest |

  Scenario Outline: S021_TC09_Verify New Placement with invalid TAC [Negative test]
    [
    
    	The Fixed Deposit Placement confirmation detail screen should show and allow user as below
    1. From accoun information
    2. Tenure information
    3. Principal Amount information 
    4. Remarks information (Optional)
    5. Maturity Instruction information 
    6. Renewal Instruction information
    7. Rate (%) information 
    8. Effective Date information
    9. Use to be able to key in with invalid TAC and click next button
    10 System will show messasge error "You've entered an invalid code. Please ensure you key in the correct code. (2076)"
    
    
    ]

    When I select From account "<FromAcctValue>" in Fixed Deposit New Placement - Enter Details Section
    And I select Tenure "<Tenure>" in Fixed Deposit New Placement - Enter Details Section
    And I key in principal amount "<Amount>" in Fixed Deposit New Placement - Enter Details Section
    And I Key in Remark "<Remark>" in Fixed Deposit New Placement - Enter Details Section
    And I select Renewal Instruction "<RenewalInstruction>" in Fixed Deposit New Placement - Enter Details Section
    And I click on Next button in Fixed Deposit New Placement - Enter Details Section
    And I key in invalid tac "<InvalidTac>" in Fixed Deposit New Placement - Confirmation Section
    And I click on Submit button in Fixed Deposit New Placement - Confirmation Section
    Then Verify the error message displayed in Fixed Deposit New Placement - Confirmation Section
      | You've entered an invalid code. Please ensure you key in the correct code. (2076) |

    Examples: 
      | FromAcctValue | Tenure    | Amount | Remark           | RenewalInstruction     | InvalidTac |
      |         10001 | 12 months |   1001 | insufficientfund | Principal and Interest |     111222 |

  
  Scenario Outline: S021_TC10_Verify New Placement Acknowledgement screen (USD currency)
    [
    
    	   The Fixed Deposit Placement Acknowledgement screen should show user as below
    	1. Reference Number informaiton 
    	2. Recipt Number information
    	3. Transaction Status information
    	4. Transaction Date,Time information 
    	5. From accoun number information
    	6. Balance After Placement information
    	7. FD Account Number information
    	8. Tenure information
    	9. Principal Amount information 
    	10. Remarks information 
    	11. Maturity Instruction information
    	12. Rate (%) information 
    	13. Effective Date information
    	14. Maturity Date information
    	15. Make Another Placement and Done button
    	16. green ribbon with Message show "You've successfully deposited your fixed deposit placement."
    
    ]

    When I select From account "<FromAcctValue>" in Fixed Deposit New Placement - Enter Details Section
    And I select Tenure "<Tenure>" in Fixed Deposit New Placement - Enter Details Section
    And I key in principal amount "<Amount>" in Fixed Deposit New Placement - Enter Details Section
    And I Key in Remark "<Remark>" in Fixed Deposit New Placement - Enter Details Section
    And I select Renewal Instruction "<RenewalInstruction>" in Fixed Deposit New Placement - Enter Details Section
    And I click on Next button in Fixed Deposit New Placement - Enter Details Section
    And I key in valid TAC in Fixed Deposit New Placement - Confirmation Section
    And I click on Submit button in Fixed Deposit New Placement - Confirmation Section
    Then Verify the success message displayed in Fixed Deposit New Placement - Acknowledgement Section
      | You've successfully deposited your fixed deposit placement. |
    And Verify other details displayed in Fixed Deposit New Placement - Acknowledgement Section
		####And I click in Make Another Placement button in Fixed Deposit New Placement - Acknowledgement Section
		####Then Fixed Deposit New Placement screen - Enter Details section is displayed
		
		
    Examples: 
      | FromAcctValue | Tenure    | Amount | Remark           | RenewalInstruction     | InvalidTac |
      |         10001 | 12 months |   1001 | insufficientfund | Principal and Interest |     111222 |
