Feature: S013_Pay & Transact Overview

  Background: 
    Given I m logged in
	

  Scenario: S013_TC01_Verify Pay & Transact Overview Section in Dashboard
    
    [ Verify that following fields are displayed 
    1. Transfer Field
    - Transfer to Own Account
    - Transfer to Other Account at HLBCAM
    - Local Transfer
    - Overseas Transfer
    2. Online Transaction Field
    - View History
    - Manage Standing Instruction
    - My QR
    3. Fixed Deposit Field
    - New Placement
    - Withdraw Placement
    ]

    When I click on Pay & Transaction menu
    Then Verify all menu options given are displayed
