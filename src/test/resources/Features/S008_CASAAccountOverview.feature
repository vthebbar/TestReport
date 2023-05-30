Feature: S008_CASA Account Overview Section and Screen features

  Background: 
    Given I m logged in

  Scenario: S008_TC01_Verify CASA Account Overview Section in Dashboard
    """ Verify these details are displayed  : Type of account, Currency, Account Number, Amount with currency at the bottom of the value """

    And I m on the Home page
    Then CASA Account Overview Section is diaplyed
    And Type of account, Currency, Account Number, Amount with currency at the bottom of the value are displayed

  Scenario: S008_TC02_Verify CASA Overview screen in Dashboard
    """ verify Available Balance box is not clickable """

    And I m navigated to account overview screen
    Then Verify that Available Balance box is not clickable

  Scenario: S008_TC03_Verify CASA Overview screen in Dashboard
    """ Verify that user is able to view Account Number, Current Balance, Account Details as of, Basic Interest Rate, Status """

    And I m navigated to account overview screen
    Then Verify that user is able to view Account Number, Current Balance, Account Details as of, Basic Interest Rate, Status

  Scenario: S008_TC04_Verify CASA Overview screen in Dashboard
    """ verify Users should be able to click and select the transaction period """

    And I m navigated to account overview screen
    Then Verify that users should be able to click and select the transaction period
	
	@TEST
  Scenario: S008_TC05_Verify CASA Overview screen in Dashboard
    """ verify Ability to click and download CSV """

    And I m navigated to account overview screen
    Then Verify that user is able to click and download CSV
	
	@TEST
  Scenario: S008_TC06_Verify CASA Overview screen in Dashboard
    """ verify Ability to click and download PDF """

    And I m navigated to account overview screen
    Then Verify that user is able to click and download PDF
    
    
	# Data not available
  #Scenario: Verify CASA Overview screen in Dashboard
    #"""  Ability to click the numbers to jump to another page """
#
    #And I m navigated to account overview screen
    #Then Verify that user is able to click the numbers to jump to another page
