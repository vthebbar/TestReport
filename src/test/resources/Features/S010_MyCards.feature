Feature: S010_My Cards (Physical Card) and My Cards Overview

  Background: 
    Given I m logged in

  Scenario: S010_TC01_Verify My Cards Overview section in Home page
    [ Verify Section heading, Card type, Card number, Hide/Unhide icon ]

    Then My cards section heading is displayed
    And Type of card is displayed
    And Card number last four digits are displayed, reamining digits masked with x
    And Hide/Unhide card information icon is displayed

  Scenario: S010_TC02_Verify Physical Debit Card Overview details
    [ Login-> Home page -> Click on physical Debit Card to verify the details ]

    When I m navigated to Physical Debit Card Overview page
    Then Card number, Valid through, CVV, Account Balance, Linked Account, Card status are displayed
    And Manage Card Settings option is displayed
    And Transaction Timeline label is displayed

  Scenario: S010_TC03_Verify Transaction Timeline table heading in Physical Debit Card Overview page
    [ Login-> Home page -> Click on physical Debit Card to verify the Transaction Timeline ]

    When I m navigated to Physical Debit Card Overview page
    Then Transaction timeline table displayed with columns headers Ref No., Date, Description, Incoming, Outgoing

  Scenario: S010_TC04_Verify Manage Card Settings for Physical Debit Card
    [ Login -> Home ->  Physical Debit Card -> Manage Card Settings -> verify options displayed are :
    Block/Unblock Physical Card ,  Block/Unblock E-Commerce,  Block/Unblock Overseas ATM/POS,  Change Debiting Account,
    Set Daily Limit,  Travel Notification Service,  Request Card Renewal,  Report Card Lost/Stolen,  Reset PIN ]

    When I m navigated to Physical Debit Card Overview page
    And I click on Manage Card Settings menu
    Then verify specified options are displayed

  Scenario: S010_TC05_Verify Block and Unblock Physical Card
    [Login -> Home ->  Physical Debit Card -> Manage Card Settings ->Block/Unblock Physical Card ]

    When I m navigated to Block/Unblock Physical Card screen
    And I click on Block button
    Then Card blocked successfully with message
      | You've successfully blocked your card! You can unblock it anytime you need to |
    When I m navigated to Block/Unblock Physical Card screen
    And I click on Unblock button
    And I enter TAC to unblock the physical debit card
    And I click on Submit button to unblock physical debit card
    Then Card unblocked successfully with message
      | You've successfully unblocked your card! |

  Scenario: S010_TC06_Verify Block and Unblock E-Commerce (Physical Debit Card)
    [ Login -> Home -> Physical Debit Card - > Manage Card Settings -> Block/Unblock E-commerce + click on Done button]

    When I m navigated to Block/Unblock E-commerce screen
    And I click on Block button to block E-commerce
    Then Card blocked successfully for E-commerce with message
      | You've successfully blocked e-commerce transaction in this debit card with immediate effect |
    And I click on Done button in Block/Unblock E-commerce screen
    Then I m navigated to Home screen
    When I m navigated to Block/Unblock E-commerce screen
    And I click on Unblock button to Unblock E-commerce
    And I enter TAC to unblock the E-commerce
    And I click on Submit button to unblock E-commerce
    Then Card unblocked successfully for E-commerce with message
      | You've successfully unblocked e-commerce transaction in this debit card with immediate effect |
    And I click on Done button in Block/Unblock E-commerce screen
    Then I m navigated to Home screen

  Scenario: S010_TC07_Verify Block and Unblock Overseas ATM/POS (Physical Debit Card)
    [ Login -> Home -> Physical Debit Card - > Manage Card Settings -> Block/Unblock Overseas ATM/POS + click on Done button]

    When I m navigated to Block/Unblock Overseas ATM/POS screen
    And I click on block button in Block/Unblock Overseas ATM/POS screen
    Then Overseas ATM/POS blocked successfully with message
      | You've successfully blocked overseas purchases and withdrawals for your card! |
    And I click on Done button in Block/Unblock Overseas ATM/POS screen
    Then I m navigated to Home screen
    When I m navigated to Block/Unblock Overseas ATM/POS screen
    And click on Unblock button in Block/Unblock Overseas ATM/POS screen
    And I enter TAC to unblock Oversaes ATM/POS
    And I click on Submit button to Unblock Oversaes ATM/POS
    Then Overseas ATM/POS Unblock successfully with message
      | You've successfully enabled overseas purchases and withdrawals of your card! |
    And I click on Done button in Block/Unblock Overseas ATM/POS screen
    Then I m navigated to Home screen

  Scenario: S010_TC08_Verify Change Debiting Account (Physical Debit Card)
    [Login -> Home -> Physical Debit Card - > Manage Card Settings -> Change Debiting Account ]

    When I m navigated to Change Debiting Account screen
    And I select new debiting account and click next button
    And I key in HLB Connect password
    And I click on Submit button in Change Debiting Account screen
    Then Debiting account successfully changed with message
      | You have successfully update the debiting account for your physical debit card. |

  Scenario: S010_TC09_Verify Change Debiting Account with Invalid Password (Physical Debit Card)
    [Login -> Home -> Physical Debit Card - > Manage Card Settings -> Change Debiting Account -> Use Invalid Password]

    When I m navigated to Change Debiting Account screen
    And I select new debiting account and click next button
    And I key in invalid HLB Connect password
      | InvalidPassword |
    And I click on Submit button in Change Debiting Account screen
    Then Error message displayed
      | Incorrect Password. Please check and retry. (2266) |

  Scenario: S010_TC10_Verify Set Daily Limit [Valid Purchase Limit and Withdrawl Limit] (Physical Debit Card)
    [Login -> Home -> Physical Debit Card - > Manage Card Settings->Set Daily Limit -> key in new valid limit]

    When I m navigated to Set Daily Limit screen
    And key in valid Purchase Limit
    And Key in valid Withdrawl Limit
    And click on Next button in Set Daily Limit screen
    And key in TAC value in Set Daily Limit screen
    And click on Submit button in Set Daily Limit screen
    Then verify the success message in Set Daily Limit screen
      | You've successfully changed the maximum daily purchase and withdrawal limit. |

  Scenario: S010_TC11_Verify Daily Purchase Limit less than USD5  [Negative test]
    [Login -> Home -> Physical Debit Card - > Manage Card Settings->Set Daily Limit -> key in Purchase Limit less than USD 5]

    When I m navigated to Set Daily Limit screen
    And Key in Purchase Limit
      | 4.99 |
    And Move cursor focus to Withdrawal Limit	input box
    Then Verify the error message
      | Invalid new limit amount. Please input a value higher than or equal to 5 (2285) |

  Scenario: S010_TC12_Verify Daily Withdrawal Limit less than USD1  [Negative test]
    [Login -> Home -> Physical Debit Card - > Manage Card Settings->Set Daily Limit -> key in Withdrawal Limit less than USD 1]

    When I m navigated to Set Daily Limit screen
    And Key in Withdrawal Limit
      | 0.99 |
    And Move cursor focus to Purchase Limit	input box
    Then Verify the error message
      | Invalid new limit amount. Please input a value higher than or equal to 1 (2286) |

  Scenario: S010_TC13_Verify Daily Purchase Limit more than maxium allowed value
    [Login -> Home -> Physical Debit Card - > Manage Card Settings->Set Daily Limit -> key in Purchase Limit more than max allowed , 5000.01]

    When I m navigated to Set Daily Limit screen
    And Key in Purchase Limit
      | 5000.01 |
    And Move cursor focus to Withdrawal Limit	input box
    Then Verify the error message
      | You have exceeded the maximum purchase limit. Please input a value of less than or equal to 5000 (2272) |

  Scenario: S010_TC13_Verify Daily Withdrawal Limit more than maxium allowed value
    [Login -> Home -> Physical Debit Card - > Manage Card Settings->Set Daily Limit -> key in Withdrawal Limit more than max allowed , 5000.01]

    When I m navigated to Set Daily Limit screen
    And Key in Withdrawal Limit
      | 5000.01 |
    And Move cursor focus to Purchase Limit	input box
    Then Verify the error message
      | You have exceeded the maximum withdrawal limit. Please input a value of less than or equal to 5000 (2273) |

  Scenario: S010_TC14_Verify Set Daily Limit using Invalid TAC [Valid Purchase Limit and Withdrawl Limit] (Physical Debit Card) [Negative test]
    [Login -> Home -> Physical Debit Card - > Manage Card Settings->Set Daily Limit -> key in new valid limit -> Key in Invalid TAC]

    When I m navigated to Set Daily Limit screen
    And key in valid Purchase Limit
    And Key in valid Withdrawl Limit
    And click on Next button in Set Daily Limit screen
    And key in invalid TAC value in Set Daily Limit screen
      | 112233 |
    And click on Submit button in Set Daily Limit screen
    Then Verify the error message in Set Daily Limit screen
      | You've entered an invalid code. Please ensure you key in the correct code. (2076) |

  Scenario: S010_TC15_Verify Create Travel Notification function
    [Login -> Home -> Physical Debit Card - > Manage Card Settings-> Travel Notification Service -> Create new Travel Notification]

    When I m navigated to Travel Notification Services Enter Details screen
    And Key in Start Date
      | 10/10/2023 |
    And Key in End Date
      | 20/10/2023 |
    And Select Destination country name, number
      | cName    | cNumber |
      | ANGUILLA |       4 |
    And Click on Submit button in Travel Notification Service screen
    Then Verify the result message
      | You've successfully set your travel notification! |
    And Debit Card, Travel Notification Service, From, To and Destination Countires are displayed
    And Click on Done button in Travel Notification Service screen
    Then User is navigated to Home page

  Scenario: S010_TC16_Verify Travel Notification Screen- Enter Details section displays Card, Date Range, Destinations
    [Login -> Home -> Physical Debit Card - > Manage Card Settings-> Travel Notification Service-> Enter Details Section]

    When I m navigated to Travel Notification Services Enter Details screen
    Then Card, Date Range, Destinations are displayed

  Scenario: S010_TC17_Verify Travel Notification Service Screen [when there are previously setup travel notifications]
    [Login -> Home -> Physical Debit Card - > Manage Card Settings-> Travel Notification Service]

    When I m navigated to Travel Notification Services
    Then Card Details, Date Range, Destination Countries, Action and Create Travel Notification button are displayed

  Scenario: S010_TC18_Verify Delete Travel Notification - Click No for confirmation pop up message
    [Login -> Home -> Physical Debit Card - > Manage Card Settings-> Travel Notification Service->Delete->No]

    When I m navigated to Travel Notification Services
    And I click on Action bin icon
    And I click on No button in confirmation pop up message
    Then I m directed back to Travel notification main screen

  Scenario: S010_TC19_verify Delete Travel Notification - Click Yes for confirmation pop up message
    [Login -> Home -> Physical Debit Card - > Manage Card Settings-> Travel Notification Service->Delete->Yes]

    When I m navigated to Travel Notification Services
    And I click on Action bin icon
    And I click on Yes button in confirmation pop up message
    Then Success message displayed as below
      | You've successfully removed the travel notification |
    And Debit Card, Travel Notification Status, From, To, Destination Countries are displayed
    And I click on Done button in Travel Notification Services Screen
    Then User is navigated to Home page

  Scenario: S010_TC20_Verify Reset PIN with invalid TAC [Negatie test]
    [ Login -> Home -> Physical Debit Card - > Manage Card Settings-> Reset PIN ]

    When I m navigated to Reset PIN page
    And Key in Create New Card PIN
      | 123456 |
    And Key in Confirm New Card PIN
      | 123456 |
    And Click on Next button in Reset PIN - Enter Details section
    And Key in Invalid TAC value in Reset PIN - Confirm Details section
      | 0000 |
    And Click on Confirm button in Reset PIN - Confirm Details section
    Then Verify the error message displayed for TAC
      | You've entered an invalid code. Please ensure you key in the correct code. (2076) |

  
  Scenario: S010_TC21_Verify Reset PIN with different PIN value from Create New Card PIN and Confirm New Card PIn fields [Negative test]
    [Login -> Home -> Physical Debit Card - > Manage Card Settings-> Reset PIN ]

    When I m navigated to Reset PIN page
    And Key in Create New Card PIN
      | 123456 |
    And Key in Confirm New Card PIN
      | 111222 |
    And Click on Next button in Reset PIN - Enter Details section
    Then Verify the error message displayed for PIN
      | PIN entered does not match. Please try again. (2270)|
	
	@TEST
  Scenario: S010_TC22_Verify Reset PIN function
    [ Login -> Home -> Physical Debit Card - > Manage Card Settings-> Reset PIN -> key in new & confirm pin ]

    When I m navigated to Reset PIN page
    And Key in Create New Card PIN
      | 123456 |
    And Key in Confirm New Card PIN
      | 123456 |
    And Click on Next button in Reset PIN - Enter Details section
    And Key in TAC value in Reset PIN - Confirm Details section
    And Click on Confirm button in Reset PIN - Confirm Details section
    Then Verify the message displayed
      | You've successfully updated your PIN. |
    And Verify Debit Card and PIN Status are displayed
    And I click on Done button in Reset PIN - Acknowledgement section
    Then User is navigated to Home page
