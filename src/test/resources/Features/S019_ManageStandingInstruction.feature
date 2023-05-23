Feature: S019_Manage Standing Instruction

  Background: 
    Given I m logged in
    And I m navigated to Manage Standing Instruction screen

  Scenario: S019_TC01_Verify Transaction Type dropdown values in Manage Standing Instruction screen
    [
     		 Transaction type
      - All
      - Own Account Transfer
      - Transfer to Other Accounts at HLBCAM
      - Local Transfer
      - Overseas Transfer
      - Bill Payment
    ]

    Then Verify available dropdown options for Transaction Type dropdown in Manage Standing Instruction screen
      | All                                  |
      | Own Account Transfer                 |
      | Transfer to Other Accounts at HLBCAM |
      | Local Transfer                       |
      | Overseas Transfer                    |
      | Bill Payment                         |

  Scenario: S019_TC02_Verify Status dropdown values in Manage Standing Instruction screen
    [
    o Status
    - All 
    - Scheduled
    - Skipped
    - Cancelled
    - Completed
    ]

    Then Verify available dropdown options for Status dropdown in Manage Standing Instruction screen
      | All       |
      | Scheduled |
      | Skipped   |
      | Cancelled |
      | Completed |

  Scenario Outline: S019_TC03_Verify Search using Transaction Type dropdown in Manage Standing Instruction screen
    [
     After search Value in Transaction Type column should match search value if data is present else, No records found.
    ]

    And Select the search value "<SearchValue>" from Transaction Type dropdown in Manage Standing Instruction screen
    And Click on Search button in Manage Standing Instruction screen
    Then Verify that Transaction Type column value in table is "<SearchResult>"

    Examples: 
      | SearchValue                          | SearchResult                         |
      | Own Account Transfer                 | Own Account Transfer                 |
      | Transfer to Other Accounts at HLBCAM | Transfer to Other Accounts at HLBCAM |
      | Local Transfer                       | Local Transfer                       |
      | Overseas Transfer                    | Overseas Transfer                    |
      | Bill Payment                         | Bill Payment                         |

  Scenario Outline: S019_TC04_Verify Search using Status dropdown in Manage Standing Instruction screen
    [
    		After search Value in Status column should match search value if data is present else,  No records found.
    ]

    And Select the search value "<Status>" from Status dropdown in Manage Standing Instruction screen
    And Click on Search button in Manage Standing Instruction screen
    Then Verify that Status column value in table is "<SearchTableStatus>"

    Examples: 
      | Status    | SearchTableStatus |
      | Scheduled | Scheduled         |
      | Skipped   | Skipped           |
      | Cancelled | Cancelled         |
      | Completed | Completed         |

  Scenario: S019_TC05_Verify Download CSV link functionality in Manage Standing Instruction screen
    [
    	 Should be able to download CSV file once click on Download CSV link.
    ]

    And I click on Download CSV link in Manage Standing Instruction screen
    Then Verify that CSV file is downloaded successfully

  Scenario: S019_TC06_Verify Manage Standing Instruction table header/field details
    [	
     Verify below headers are displayed:
     - REF NO
    - NEXT PROCESS DATE
    - FROM ACCOUNT
    - TO ACCOUNT
    - TRANSACTION TYPE
    - AMOUNT
    - STATUS
    - ACTIONS
    ]

    Then Verify table headers are displayed correctly in Manage Standing Instruction screen

  Scenario: S019_TC07_Verify the Repeat button functionality in Manage Standing Instruction screen
    [
    	Manage Standing Instruction screen -> Repeat -> complete the transaction
    ]

    And Search for Local Transfer Transaction in Manage Standing Instruction screen
      | Local Transfer |
    And I click on Repeat button in Manage Standing Instruction screen
    And Key in the amount in Local Transfer - Details entry section
      | 11 |
    And Complete the Local Transfer Transaction
    Then Verify the success message in Local Transfer - Acknowledgement section
      | You've successfully completed the transfer |

  Scenario: S019_TC08_Verify Standing Instruction Details are displayed by clicking on the REF NO. link
    [
    Click on REF NO.  and verify the details of standing instruction.
    ]

    And I click on the REF NO. link in Manage Standing Instruction screen
    |Local Transfer|
    Then Verify Standing Instruction details are displayed in Standing Instruction details screen

  Scenario: S019_TC09_Verify Repeat button functionality in Standing Instruction Details screen
    [
    	Manage Standing Instruction screen -> Click on any REF No. -> Repeat-> complete the transaction (Local Transfer)
    ]

    And I click on the REF NO. link in Manage Standing Instruction screen
    |Local Transfer|
    And I click on Repeat button in Manage Standing Instruction Details screen
    And Key in the amount in Local Transfer - Details entry section
      | 11 |
    And Complete the Local Transfer Transaction
    Then Verify the success message in Local Transfer - Acknowledgement section
      | You've successfully completed the transfer |
  
  
  Scenario: S019_TC10_Verify Back button functionality in Standing Instruction Details screen
    [
    Manage Standing Instruction screen ->click  REFO NO -> click Back -> Manage Standing Instruction screen 
    ]

    And I click on the REF NO. link in Manage Standing Instruction screen
    |Local Transfer|
    And I click on Back button in Standing Instruction Details screen
    Then Manage Standing Instruction screen is displayed
