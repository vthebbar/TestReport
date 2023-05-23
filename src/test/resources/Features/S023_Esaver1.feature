Feature: S023_ Esaver feature -Esaver Account section Overview

  Background: 
    Given I m logged in
	
	
  Scenario: S023_TC01_Verify E- Saver Account Overview Section in Home page
    [
    	 The E- Saver Account Overview screen should show user as below
    	- user clicks on “E- Saver Account", a pop-up will appear with the following :
    	1. Create Account
    	2. Personalize Account
    	3. Re-activate Account
    	4. Close Account
    	5. View Application History
    
    ]

    When I Click on E-Saver menu in home page
    Then Menus specified above are displayed
