Feature: S012_Quick Access Overview

  Background: 
    Given I m logged in
	
	@TEST
  Scenario: S012_TC01_Verify Quick Access Overview Section in Dashboard
    [ The Quick Access Overview screen should show user as below:
    1. Transfer To” with the below
    • Own Account
    • Other Account at HLBCAM
    • Local Transfer
    • Overseas Transfer
    ]

    Then Quick Access Overview Section is displayed with given menu options
   
