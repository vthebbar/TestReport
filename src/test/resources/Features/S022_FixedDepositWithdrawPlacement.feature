Feature: S022_Withdraw placement (Fixed Deposit)

  Background: 
    Given I m logged in
    And I m navigated to Fixed Deposit Overview screen

  Scenario Outline: S022_TC01_Verify Fixed Deposit Overview screen
    When I select Account Number "<AcctNum>" from dropdown in Fixed Deposit Overview screen
    Then Available Balance is displayed in Fixed Deposit Overview screen
    And Equivalent Balance is displayed in Fixed Deposit Overview screen

    Examples: 
      | AcctNum                            |
      | 6-01-0001-99000048-0 Fixed Deposit |

  Scenario: S022_TC02_Verify Placements details table header
    Then Verify table headers are displayed correctly in Fixed Deposit Overview Overview screen

  Scenario Outline: S022_TC03_Verify Download CSV link functionality
    When I select Account Number "<AcctNum>" from dropdown in Fixed Deposit Overview screen
    When I click on Download CSV link in Fixed Deposit Overview screen
    Then Verify CSV file is downloaded successfully

    Examples: 
      | AcctNum                            |
      | 6-01-0001-99000048-0 Fixed Deposit |

  Scenario Outline: S022_TC04_Verify fixed deposit details by clicking on the Receipt number
    [
      1. The FD Detail page will enable user to view below:
        - Account
        - account status
        - principal amount
        - Tenure
        - Rate
        - last renewal date
        - placement date
        - maturity date
        -  renewal instruction
        - interest payment account
        - accrued interest
        - auto renewal
      2. user able to click on withdraw and proceed to the withdrawal flow
      3. user able to click back to go back to main withdrawal screen
    
    ]

    When I select Account Number "<AcctNum>" from dropdown in Fixed Deposit Overview screen
    And I click on Receipt number link in Fixed Deposit Overview screen
    Then Verify Fixed Deposit Placement Detail screen

    Examples: 
      | AcctNum                            |
      | 6-01-0001-99000048-0 Fixed Deposit |

  Scenario Outline: S022_TC05_Verify Fixed Deposit withdraw - Confirm Details screen
    [
     		The Withdrawal  (Fixed Deposit) confirmation detail screen should show user as below
    1. Confirmation detail page,
      - Account information
      - Tenure information
      - Rate (%) information
      - Maturity Date information
      - Principal Amount information
      - Accrued Interest information
      - Transfer to Account information
    
    ]

    When I select Account Number "<AcctNum>" from dropdown in Fixed Deposit Overview screen
    And I click on Withdraw button in Fixed Deposit Overview screen
    Then Verify Fixed Deposit withdraw - Confirm Details section

    Examples: 
      | AcctNum                            |
      | 6-01-0001-99000048-0 Fixed Deposit |

  Scenario Outline: S022_TC06_Verify Fixed Deposit Withdraw using invalid TAC  [Negative test]
    When I select Account Number "<AcctNum>" from dropdown in Fixed Deposit Overview screen
    And I click on Withdraw button in Fixed Deposit Overview screen
    And I click on Next button in Fixed Deposit withdraw - Confirm Details section
    And I Key in invalid TAC in Fixed Deposit withdraw - Confirm Details section
      | 112233 |
    And I click on Submit button in Fixed Deposit withdraw - Confirm Details section
    Then Verify the error message in Fixed Deposit withdraw - Confirm Details section
      | You've entered an invalid code. Please ensure you key in the correct code. (2076) |

    Examples: 
      | AcctNum                            |
      | 6-01-0001-99000048-0 Fixed Deposit |

  Scenario Outline: S022_TC07_Verify Fixed Deposit Withdraw Acknowledgement detail screen & Click on Make a Placement button (using Withdraw button in Fixed Deposit Overview screen )
    [
      Test FD withdraw function:
      Fixed Deposit Overview screen -> Withdraw button
      Click Make a Placement button in Acknowledgement screen
    ]

    When I select Account Number "<AcctNum>" from dropdown in Fixed Deposit Overview screen
    And I click on Withdraw button in Fixed Deposit Overview screen
    And I click on Next button in Fixed Deposit withdraw - Confirm Details section
    And I Key in valid TAC in Fixed Deposit withdraw - Confirm Details section
    And I click on Submit button in Fixed Deposit withdraw - Confirm Details section
    Then Verify the success message in Fixed Deposit withdraw - Confirm Details section
      | You have successfully withdrawn your fixed deposit. |
    And Verify the details are displayed in Fixed Deposit withdraw - Acknowledgement section
    And I click on Make a Placement button in Fixed Deposit withdraw - Acknowledgement section
    Then Fixed Deposit placement - Details Entry screen displayed

    Examples: 
      | AcctNum                            |
      | 6-01-0001-99000048-0 Fixed Deposit |

  
  Scenario Outline: S022_TC08_Verify Fixed Deposit Withdraw Acknowledgement detail screen & Click on Done button (using Withdraw button in Fixed Deposit Details screen )
    [
    Test FD withdraw function:
    Fixed Deposit Overview screen -> Receipt Link -> Withdraw button
    Click Done button in Acknowledgement screen
    ]

    When I select Account Number "<AcctNum>" from dropdown in Fixed Deposit Overview screen
    And I click on Receipt number link in Fixed Deposit Overview screen
    And I click on Withdraw button in Fixed Deposit Placement Details screen
    And I click on Next button in Fixed Deposit withdraw - Confirm Details section
    And I Key in valid TAC in Fixed Deposit withdraw - Confirm Details section
    And I click on Submit button in Fixed Deposit withdraw - Confirm Details section
    Then Verify the success message in Fixed Deposit withdraw - Confirm Details section
      | You have successfully withdrawn your fixed deposit. |
    And Verify the details are displayed in Fixed Deposit withdraw - Acknowledgement section
    And I click on Done button in Fixed Deposit withdraw - Acknowledgement section
    Then I m navigated to home page

    Examples: 
      | AcctNum                            |
      | 6-01-0001-99000048-0 Fixed Deposit |
