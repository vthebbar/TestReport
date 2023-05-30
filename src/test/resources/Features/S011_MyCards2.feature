Feature: S011_My Cards Section - Virtual Debit Card

  Background: 
    Given I m logged in

  Scenario: S011_TC01_Verify Virtual Debit Card Overview screen (Verify Card Image)
    [Login -> Virtual Debit Card (My Cards section) -> Verify Card Image]

    When I m navigated to Virtual Debit Card Overview screen
    Then Card Number, Valid Thru and CVV are displayed

  Scenario: S011_TC02_Verify Virtual Debit Card Overview screen (Account Balance, Linked Account, Card Status and Note)
    [Login -> Virtual Debit Card (My Cards section) -> Verify Account Balance, Linked Account, Card Status and Note are displayed]

    When I m navigated to Virtual Debit Card Overview screen
    Then Account Balance, Linked Account, Card Status and Note are displayed

  Scenario: S011_TC03_Verify Virtual Debit Card Overview screen (Transaction Timeline heading)
    [Login -> Virtual Debit Card (My Cards section) -> Verify Transaction Timeline table headings are displayed]

    When I m navigated to Virtual Debit Card Overview screen
    Then Transaction Timeline is displayed
    And Ref No, Date, Description, Incoming, Outgoing are displayed

  Scenario: S011_TC04_Verify Virtual Debit Card Overview screen (Manage Card Settings option is displayed)
    [Login -> Virtual Debit Card (My Cards section) -> Verify Manage Card Settings option is displayed]

    When I m navigated to Virtual Debit Card Overview screen
    Then Manage Card Settings option is displayed

  Scenario: S011_TC05_Verify Manage Card Settings options for Virtual Card
    [Login -> Virtual Debit Card (My Cards section) -> Manage Card Settings -> ]
    options displayed are: Block/Unblock Virtual Card, Change Debiting Account, Set Daily Limit, Create/Update Note]

    When I m navigated to Virtual Debit Card Overview screen
    And I click on Manage Card Settings option
    Then Block/Unblock Virtual Card,Change Debiting Account, Set Daily Limit, Create/Update Note are displayed

  Scenario: S011_TC06_Verify Block/Unblock Virtual Card screen
    [Login -> Virtual Debit Card (My Cards section) -> Manage Card Settings -> Block/Unblock Virtual Debit Card]

    When I m naviagted to Block/Unblock Virtual Card - Enter Details section
    Then Alert, Card Details, Card Status, Action are displayed

  Scenario: S011_TC07_Verify Block Virtual Card function
    [Login -> Virtual Debit Card (My Cards section) -> Manage Card Settings -> Block/Unblock Virtual Debit Card -> Block]

    When I m naviagted to Block/Unblock Virtual Card - Enter Details section
    And I click on Block button in Block/Unblock Virtual Card screen - Enter Details section
    Then Message displayed as below
      | You've successfully blocked your virtual card. |
    And I click on Done button in Block/Unblock Virtual Card - Acknowledgement section
    Then I m navigated to home page

  Scenario: S011_TC08_Verify Block/Unblock Virtual Card screen after blocking the Virtual Card
    [ Pre-condition :Virtual Card should be blocked , Login -> Virtual Debit Card (My Cards section) -> Manage Card Settings -> 
    Block/Unblock Virtual Debit Card]

    When I m naviagted to Block/Unblock Virtual Card - Enter Details section
    Then Card Status is displayed as Blocked
    And Unblock action button is displayed

  Scenario: S011_TC09_Verify Block/Unblock Virtual Card function using Invalid TAC code  [Netaive test]
       [Login -> Virtual Debit Card (My Cards section) -> Manage Card Settings -> Block/Unblock Virtual Debit Card -> Unblock - Key in Invlaid TAC]

    When I m naviagted to Block/Unblock Virtual Card - Enter Details section
    And I click on Unblock button in Block/Unblock Virtual Card screen - Enter Details section
    And I enter Invalid TAC in Block/Unblock Virtual Card screen - Confirm Details section
      | 123456 |
    And I click on Submit button in Block/Unblock Virtual Card screen - Confirm Details section
    Then For invalid TAC submission Message displayed as below
      | You've entered an invalid code. Please ensure you key in the correct code. (2076) |

  Scenario: S011_TC10_Verify Unblock Virtual Card function
    [Login -> Virtual Debit Card (My Cards section) -> Manage Card Settings -> Block/Unblock Virtual Debit Card -> Unblock]

    When I m naviagted to Block/Unblock Virtual Card - Enter Details section
    And I click on Unblock button in Block/Unblock Virtual Card screen - Enter Details section
    And I enter valid TAC in Block/Unblock Virtual Card screen - Confirm Details section
    And I click on Submit button in Block/Unblock Virtual Card screen - Confirm Details section
    Then Message displayed as below
      | You've successfully unblocked your virtual card. |
    And I click on Done button in Block/Unblock Virtual Card - Acknowledgement section
    Then I m navigated to home page

  Scenario: S011_TC11_Verify Change Debiting Account screen (Virtual Card)
    [ Login - >Virtual Debit Card (My Cards section) -> Manage Card Settings -> Change Debiting Account ]

    When I m navigated to Change Debiting Account screen- Enter Details section
    Then Debit Card numer, Current Debiting account, New Debiting account dropdown and Next button are displayed

  Scenario: S011_TC12_Perform Change Debiting Account function (Virtual Card)
      [ Login - >Virtual Debit Card (My Cards section) -> Manage Card Settings -> Change Debiting Account ]

    When I m navigated to Change Debiting Account screen- Enter Details section
    And Select new Debiting account and click on Next button
    And Key in valid HLB Connect Password
      | Testing168 |
    And Click on Submit button in Change Debiting Account screen- Confirm Details section
    Then Verify the response message dispalyed as below, after change in debiting account
      | You have successfully changed the debiting account for this virtual card with immediate effect |
    And Verify Debit Card and New Debiting Account are displayed
    And Click on Done  button in Change Debiting Account screen- Acknowledgement section
    Then I m navigated to home page

  Scenario: S011_TC13_Perform Change Debiting Account function using Invlaid HLB Connect Password (Virtual Card) [Negative test]
    [ Login - >Virtual Debit Card (My Cards section) -> Manage Card Settings -> Change Debiting Account ]

    When I m navigated to Change Debiting Account screen- Enter Details section
    And Select new Debiting account and click on Next button
    And Key in Invalid HLB Connect Password
      | InvalidPwd |
    And Click on Submit button in Change Debiting Account screen- Confirm Details section
    Then Verify error message dispalyed as below, while changing debiting account
      | Incorrect Password. Please check and retry. (2266) |

  Scenario: S011_TC14_Verify Set Daily Limit screen (Virtual Debit Card)
    When I m navigated to Set Daily Limit screen - Enter Details section
    Then Debit Card , Limit Type, Max Daily Limit, Current Daily Limit, New Daily Limit fields are displayed

  Scenario: S011_TC15_Verify Set Daily Limit function (Virtual Debit Card)
    When I m navigated to Set Daily Limit screen - Enter Details section
    And Key in valid value for New Daily Limit
    And Click on Next button in Set Daily Limit screen - Enter Details section
    And Key in valid in TAC in Set Daily Limit screen - Confirm Details section
    And Click on Submit button in Set Daily Limit screen - Confirm Details section
    Then Verfy the response message in Set Daily Limit screen - Acknowledgement section
      | You've successfully changed the maximum daily purchase limit. |
    And Verify Debit card and New Limit are displayed in Set Daily Limit screen - Acknowledgement section
    And Click in Done button in Set Daily Limit screen - Acknowledgement section
    Then I m navigated to home page

  Scenario: S011_TC16_Verify Set Daily Limit Value less than minimum allowed value of 5 (Virtual Debit Card)[Negative test]
    When I m navigated to Set Daily Limit screen - Enter Details section
    And Key in value for New Daily Limit
      | 4.99 |
    And Click on Next button in Set Daily Limit screen - Enter Details section
    Then Verify the error message displayed in Set Daily Limit screen - Enter Details section
      | Invalid new limit amount. Please input a value higher than or equal to 5 (2285) |

  Scenario: S011_TC17_Verify Set Daily Limit Value more than maximum allowed value of 5000 (Virtual Debit Card)[Negative test]
    When I m navigated to Set Daily Limit screen - Enter Details section
    And Key in value for New Daily Limit
      | 5000.01 |
    And Click on Next button in Set Daily Limit screen - Enter Details section
    Then Verify the error message displayed in Set Daily Limit screen - Enter Details section
      | You have exceeded the maximum purchase limit. Please input a value of less than or equal to 5000 (2272) |

  Scenario: S011_TC18_Verify Set Daily Limit function using Invalid TAC (Virtual Debit Card) [Negative test]
    When I m navigated to Set Daily Limit screen - Enter Details section
    And Key in valid value for New Daily Limit
    And Click on Next button in Set Daily Limit screen - Enter Details section
    And Key in invalid in TAC in Set Daily Limit screen - Confirm Details section
      | 123456 |
    And Click on Submit button in Set Daily Limit screen - Confirm Details section
    Then Verfy the error message in Set Daily Limit screen - Confirm Details section
      | You've entered an invalid code. Please ensure you key in the correct code. (2076) |

  Scenario: S011_TC19_Verify Create / Update Note Screen (Virtual Debit Card)
    When I m navigated to Create/Update Note - Enter Details Section
    Then Virtual Debit Card, Current Note and New note filed are displayed

  @TEST
  Scenario: S011_TC20_Verify Create / Update Note functionaality (Virtual Debit Card)
    When I m navigated to Create/Update Note - Enter Details Section
    And Key in the value for New Note field in Create/Update Note screen - Enter Details Section
      | MyVirtualDebitCard |
    And Click on Save button in Create/Update Note screen - Enter Details Section
    Then Response message displayes in Create/Update Note screen - Acknowledgement Section
      | You've updated the note successfully! |
    And Debit Card and New Note displayed in Create/Update Note screen - Acknowledgement Section
    When Click on Done button in Create/Update Note screen - Acknowledgement Section
    Then I m navigated to home page
