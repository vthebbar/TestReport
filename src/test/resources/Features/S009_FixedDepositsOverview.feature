Feature: S009_Fixed Deposits Overview Section in Home page

  Background: 
    Given I m logged in

  Scenario Outline: S009_TC01_Verify New Fixed Deposit Placement functionality [KHR]
    New Fixed Deposit placement using KHR currency account

    When I m navigated to Fixed Deposit Placement screen
    And I enter the Fixed Deposit details "<from>" , "<tenure>" , "<principal>" , "<remarks>" , "<renewalInstruction>"
    And I enter the valid TAC for fd placement
    Then verify the Transaction status "<status>"

    Examples: 
      | from  | tenure    | principal | remarks | renewalInstruction | status     |
      | 10000 | 18 months | 4,000,000 | FD KHR  | Principal only     | Successful |

  Scenario: S009_TC02_Verify Fixed Deposits Account Overview Section in Dashboard
    """ Verify these detauks are displayed -  Type of Fixed Deposit, Currency, Fixed Deposit Account Number, Upcoming Maturity Date,"""
    """Amount with currency at the bottom of the value"""

    When I m on the Home page
    Then Fixed Deposit, Currency, Fixed Deposit Account Number, Upcoming Maturity Date, Amount with currency at the bottom of the value are displayed

  Scenario: S009_TC03_Verify Fixed Deposits Overview screen
    """ verify that Receipt number, principal amount, Tenure,  Placement Date, Maturity Date, Rate, Renewal Instruction, Actions are displayed """

    When I m navigated to Fixed Deposit Overview Screen
    Then Receipt number, principal amount, Tenure,  Placement Date, Maturity Date, Rate, Renewal Instruction, Actions are displayed

  Scenario: S009_TC04_Verify Fixed Deposits Overview screen
    """ verify that able to download CSV """

    When I m navigated to Fixed Deposit Overview Screen
    Then I m able to download CSV

  Scenario: S009_TC05_Verify Fixed Deposits Overview screen
    """ verify that User is able to View Fixed Deposit details [ Account, Account Status , Principal Amount (KHR), Tenure, Rate(%) """
    """ Last Renewal Date	,Placement Date	, Maturity Date	, Renewal Instruction	, Interest Payment Account, """
    """ Accrued Interest (KHR)	, Auto Renewal	] by clicking on Receipt No. """

    When I m navigated to Fixed Deposit Overview Screen
    And I click on Receipt No.
    Then Receipt details are displayed

  Scenario: S009_TC06_Verify Fixed Deposits Overview screen
    """ verify that user is able to withdraw Fixed Deposit by clicking Withdraw button in Fixed Deposit Overview screen"""

    When I m navigated to Fixed Deposit Overview Screen
    And I click on Withdraw button
    And I click on Next button fro Fixed Deposit Withdrawl screen
    And I enter the valid TAC
    And I click on Submit button
    Then Fixed Deposit withdrawl is successful
